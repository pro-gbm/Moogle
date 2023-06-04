package com.progbm.Moogle.movie;

import com.progbm.Moogle.util.Provider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

    @Test
    @DisplayName("영화 목록에서 가장 많은 갯수를 차지한 OTT 반환 테스트")
    public void countMovieOttTest() {
        // given
        List<Long> movieIds = movieService.getMovies().stream().map(Movie::getId).toList();

        // when
        Map<Provider, Integer> map = new EnumMap<>(Provider.class);
        movieService.countMovieOtt(map, movieIds);

        // then
        String result = Provider.NETFLIX.toString();
        int count = map.get(Provider.NETFLIX);
        for (Map.Entry<Provider, Integer> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            int value = entry.getValue();

            if (value > count) {
                result = key;
                count = value;
            }
        }

        for (Map.Entry<Provider, Integer> entry : map.entrySet()) {
            System.out.println("***********************");
            System.out.println("OTT = " + entry.getKey());
            System.out.println("count = " + entry.getValue());
            System.out.println("***********************");
        }
    }
}