package com.progbm.Moogle.tmdb;

import com.progbm.Moogle.nation.NationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class TmdbServiceTest {

    @Autowired
    private TmdbService tmdbService;

    @Test
    public void tmdbApiCallTest() {
        PopularMovieResponse popularMovies = tmdbService.getPopularMovies();
        System.out.println("popularMovies = " + popularMovies);
    }

    @Test
    public void getGenres() {
        GenreResponse genres = tmdbService.getGenres();
        System.out.println("genres = " + genres);
    }

    @Test
    public void getNations() {
        NationResponse[] nations = tmdbService.getNations();
        System.out.println("nations = " + Arrays.toString(nations));
    }
}