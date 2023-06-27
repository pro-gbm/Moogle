package com.progbm.Moogle.movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MovieTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @DisplayName("Movie 엔티티 저장 및 조회")
    public void create() {
        // given
        Movie movie = Movie.builder()
                .title("영화1")
                .openingDate(LocalDateTime.now())
                .score(9.1d)
                .attendance(1000)
                .build();

        // when
        Movie saveMovie = movieRepository.save(movie);
        Movie findMovie = movieRepository.findById(saveMovie.getId()).orElseThrow();

        // then
        assertThat(saveMovie.getId()).isEqualTo(findMovie.getId());
    }

}