package com.progbm.Moogle.tmdb;

import com.progbm.Moogle.tmdb.response.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void getPopularPerson() {
        PopularPersonResponse popularActor = tmdbService.getPopularPerson(1);
        System.out.println("popularActor = " + popularActor);
    }

    @Test
    public void getOtts() {
        OttResponse ottResponse = tmdbService.getOtts();
        System.out.println("otts = " + ottResponse);
    }

    @Test
    public void getMovieProviders() {
        MovieProviderResponse movieProviderResponse = tmdbService.getMovieProviders(505642);
        System.out.println("movieProvider = " + movieProviderResponse);
    }
}