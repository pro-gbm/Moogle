package com.progbm.Moogle.genre;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GenreServiceTest {

    @Autowired
    private GenreService genreService;

    @Test
    @DisplayName("장르 삽입 & 조회 테스트")
    @Transactional
    public void insertGenresTest() {
        // given
        genreService.insertGenres();

        // when
        List<Genre> genres = genreService.getGenres();

        // then
        System.out.println(genres.size());
        assertThat(!genres.isEmpty());
    }

}