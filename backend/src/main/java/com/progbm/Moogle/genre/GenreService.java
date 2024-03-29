package com.progbm.Moogle.genre;

import com.progbm.Moogle.tmdb.response.GenreResponse;
import com.progbm.Moogle.tmdb.TmdbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;
    private final TmdbService tmdbService;

    public void saveGenres() {
        Set<Integer> savedGenreTmdbIds = genreRepository.findAll().stream().map(Genre::getTmdbId).collect(Collectors.toSet());

        GenreResponse genreResponse = tmdbService.getGenres();
        List<Genre> genres = genreResponse.getGenres().stream()
                .map(movieGenre -> Genre.builder().tmdbId(movieGenre.getId()).name(movieGenre.getName()).build())
                .collect(Collectors.toList());

        genres = genres.stream().filter(genre -> !savedGenreTmdbIds.contains(genre.getTmdbId())).collect(Collectors.toList());

        genreRepository.saveAll(genres);
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Long id) {
        return genreRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
