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
    public void findByTIdTest() {
        // given
        int genreTId = 28;

        // when
        Genre genre = genreRepository.findByTmdbId(genreTId).get();
        System.out.println("genre = " + genre);

        // then
        assertThat(genre).isNotNull();
    }
}