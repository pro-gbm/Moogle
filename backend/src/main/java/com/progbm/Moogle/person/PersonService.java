package com.progbm.Moogle.person;

import com.progbm.Moogle.actor.Actor;
import com.progbm.Moogle.actor.ActorRepository;
import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.director.DirectorRepository;
import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.PopularPersonResponse;
import com.progbm.Moogle.util.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final TmdbService tmdbService;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;

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
                    .filter(popularPerson -> popularPerson.getKnownForDepartment() != null)
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

        return actorsFromPopular.stream().map(actor ->
                Actor.builder()
                        .tmdbId(actor.getId())
                        .name(actor.getName())
                        .gender(Gender.getGender(actor.getGender()))
//                        .nation()
                        .thumbnailUrl(actor.getProfilePath())
                        .build()).collect(Collectors.toList());

    }

    private List<Director> getDirectorsFromPage(List<PopularPersonResponse.PopularPerson> directorsFromPopular) {
        if (directorsFromPopular == null || directorsFromPopular.isEmpty()) return new ArrayList<>();

        return directorsFromPopular.stream().map(director ->
                        Director.builder()
                                .tmdbId(director.getId())
                                .name(director.getName())
                                .gender(Gender.getGender(director.getGender()))
//                        .nation()
                                .thumbnailUrl(director.getProfilePath())
                                .build()
        ).collect(Collectors.toList());

    }

}
