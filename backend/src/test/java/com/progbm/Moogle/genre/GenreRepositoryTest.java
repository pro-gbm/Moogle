package com.progbm.Moogle.genre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class GenreRepositoryTest {

    @Autowired
    GenreRepository genreRepository;

    @Test
    public void findByTmdbIdTest() {
        // given
        int genreTmdbId = 28;

        // when
        Genre genre = genreRepository.findByTmdbId(genreTmdbId).get();
        System.out.println("genre = " + genre);

        // then
        assertThat(genre).isNotNull();
    }
}