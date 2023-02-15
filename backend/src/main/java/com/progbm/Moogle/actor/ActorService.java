package com.progbm.Moogle.actor;

import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.ActorResponse;
import com.progbm.Moogle.tmdb.response.PopularActorResponse;
import com.progbm.Moogle.util.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final TmdbService tmdbService;
    private final ActorRepository actorRepository;

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    public void saveActor() {

        int page = 1;

        List<Integer> savedMovieTmdbIds = actorRepository.findAll().stream().map(Actor::getTmdbId).collect(Collectors.toList());

        for (int i = 1; i <= page; i++) {
            PopularActorResponse popularActors = tmdbService.getPopularActor(i);

            List<Actor> actors = popularActors.getResults().stream().map(popularActor -> {
                ActorResponse actor = tmdbService.getActor(popularActor.getId());
                return Actor.builder()
                        .tmdbId(popularActor.getId())
                        .name(popularActor.getName())
                        .age(actor.getBirthday() == null ? 0 : birthDayToAge(actor.getBirthday()))
                        .gender(Gender.getGender(actor.getGender()))
//                        .nation()
                        .thumbnailUrl(actor.getProfilePath())
                        .build();
            }).collect(Collectors.toList());

            actors = actors.stream().filter(actor -> !savedMovieTmdbIds.contains(actor.getTmdbId())).collect(Collectors.toList());

            actorRepository.saveAll(actors);
        }

    }

    public int birthDayToAge(String birthday) {
        return Period.between(LocalDate.parse(birthday), LocalDate.now()).getYears();
    }
}
