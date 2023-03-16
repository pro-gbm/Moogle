package com.progbm.Moogle.movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    @DisplayName("인기 영화 목록 저장 & 조회 테스트")
    @Transactional
    public void savePopularMoviesTest() {
        // given
        movieService.savePopularMovies(1);

        // when
        List<Movie> movies = movieService.getMovies();
        System.out.println("movies = " + movies);

        // then
        assertThat(movies.isEmpty());
    }

    @Test
    @DisplayName("MovieProvider 삽입 테스트")
    @Transactional
    public void addMovieProvider() {
        // given
        movieService.addMovieProvider(505642);
    }

}