package com.progbm.Moogle.tmdb;

import com.progbm.Moogle.tmdb.response.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TmdbServiceTest {

    @Autowired
    private TmdbService tmdbService;

    @Test
    public void getPopularMovies() {
        PopularMovieResponse popularMovies = tmdbService.getPopularMovies(1);
        System.out.println("popularMovies = " + popularMovies);
    }

    @Test
    public void getGenres() {
        GenreResponse genres = tmdbService.getGenres();
        System.out.println("genres = " + genres);
    }

    @Test
    public void getNations() {
        List<NationResponse> nations = tmdbService.getNations();
        System.out.println("nations = " + nations);
    }

    @Test
    public void getActor() {
        int personId = 974169;
        ActorResponse actorResponse = tmdbService.getActor(personId);
        System.out.println("actorResponse = " + actorResponse);
    }

    @Test
    public void getPopularActor() {
        PopularActorResponse popularActor = tmdbService.getPopularActor(1);
        System.out.println("popularActor = " + popularActor);
    }

    @Test
    public void getOtts() {
        OttResponse ottResponse = tmdbService.getOtts();
        System.out.println("otts = " + ottResponse);
    }
}