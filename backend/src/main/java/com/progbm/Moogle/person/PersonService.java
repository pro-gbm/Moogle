package com.progbm.Moogle.person;

import com.progbm.Moogle.actor.Actor;
import com.progbm.Moogle.actor.ActorRepository;
import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.director.DirectorRepository;
import com.progbm.Moogle.ott.OttRepository;
import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.MovieProviderResponse;
import com.progbm.Moogle.tmdb.response.PopularPersonResponse;
import com.progbm.Moogle.util.Gender;
import com.progbm.Moogle.util.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final TmdbService tmdbService;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final OttRepository ottRepository;

    /**
     * 감독 조회
     * @return
     */
    public List<Director> getDirectors() {
        List<Director> director = directorRepository.findAll();

        return director;
    }

    /**
     * 배우 조회
     * @return
     */
    public List<Actor> getActors() {
        List<Actor> actors = actorRepository.findAll();

        return actors;
    }

    /**
     * TMDB API 에서 유명인 데이터 중 배우, 감독을 구분하여 저장
     */
    @Transactional
    public void savePerson(int page) {

        List<Integer> savedActorTmdbIds = actorRepository.findAll().stream().map(Actor::getTmdbId).collect(Collectors.toList());
        List<Integer> savedDirectorTmdbIds = directorRepository.findAll().stream().map(Director::getTmdbId).collect(Collectors.toList());
        List<Actor> actors = new ArrayList<>();
        List<Director> directors = new ArrayList<>();

        for (int i = 1; i <= page; i++) {
            PopularPersonResponse popularPeople = tmdbService.getPopularPerson(i);

            Map<String, List<PopularPersonResponse.PopularPerson>> map = popularPeople.getResults().stream()
                    .filter(popularPerson -> Objects.nonNull(popularPerson.getKnownForDepartment()))
                    .collect(Collectors.groupingBy(PopularPersonResponse.PopularPerson::getKnownForDepartment));

            actors.addAll(getActorsFromPage(map.get("Acting")));
            directors.addAll(getDirectorsFromPage(map.get("Directing")));
        }

        actors = actors.stream().filter(actor -> !savedActorTmdbIds.contains(actor.getTmdbId())).collect(Collectors.toList());
        directors = directors.stream().filter(director -> !savedDirectorTmdbIds.contains(director.getTmdbId())).collect(Collectors.toList());


        actorRepository.saveAll(actors);
        directorRepository.saveAll(directors);
    }

    private List<Actor> getActorsFromPage(List<PopularPersonResponse.PopularPerson> actorsFromPopular) {
        if (actorsFromPopular == null || actorsFromPopular.isEmpty()) return new ArrayList<>();

        return actorsFromPopular.stream().map(actor -> {
            // 배우가 출연한 영화 id 목록
            List<Integer> appearedMovieIds = actor.getKnownFor().stream()
                    .filter(knownFor -> "movie".equals(knownFor.getMediaType()))
                    .map(knownFor -> knownFor.getId())
                    .collect(Collectors.toList());

            Provider provider = this.getProvider(appearedMovieIds);

            return Actor.builder()
                    .tmdbId(actor.getId())
                    .name(actor.getName())
                    .gender(Gender.getGender(actor.getGender()))
                    .thumbnailUrl(actor.getProfilePath())
                    .provider(provider)
                    .build();
        }).collect(Collectors.toList());
    }

    private List<Director> getDirectorsFromPage(List<PopularPersonResponse.PopularPerson> directorsFromPopular) {
        if (directorsFromPopular == null || directorsFromPopular.isEmpty()) return new ArrayList<>();

        return directorsFromPopular.stream().map(director -> {
            // 감독이 연출한 영화 id 목록
            List<Integer> appearedMovieIds = director.getKnownFor().stream()
                    .filter(knownFor -> "movie".equals(knownFor.getMediaType()))
                    .map(knownFor -> knownFor.getId())
                    .collect(Collectors.toList());

            Provider provider = this.getProvider(appearedMovieIds);

            return Director.builder()
                    .tmdbId(director.getId())
                    .name(director.getName())
                    .gender(Gender.getGender(director.getGender()))
                    .thumbnailUrl(director.getProfilePath())
                    .provider(provider)
                    .build();
        }).collect(Collectors.toList());
    }


    private Provider getProvider(List<Integer> appearedMovieIds) {
        try {
            final Map<Provider, Integer> map = new LinkedHashMap<>();

            // 영화 id 마다 TMDB OTT 확인 API 요청
            for (Integer movieId : appearedMovieIds) {
                MovieProviderResponse movieProviders = tmdbService.getMovieProviders(movieId);

                Set<Integer> providerIds = movieProviders.getResults()
                        .getCountry()
                        .getFlatrate()
                        .stream()
                        .map(MovieProviderResponse.Flatrate::getProviderId)
                        .collect(Collectors.toSet());

                for (Provider provider : Provider.values()) {
                    if (providerIds.contains(provider.providerId)) {
                        int count = map.getOrDefault(provider, 0);
                        map.put(provider, count + 1);
                    }
                }
            }

            Provider provider = map.entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(Provider.NETFLIX);
            return provider;
        } catch (Exception e) {
            return Provider.DISNEY;
        }
    }
}
