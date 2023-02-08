package com.progbm.Moogle.genre;

import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.GenreResponse;
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
        Set<Integer> savedGenreTIds = genreRepository.findAll().stream().map(Genre::getTId).collect(Collectors.toSet());

        GenreResponse genreResponse = tmdbService.getGenres();
        List<Genre> genres = genreResponse.getGenres().stream()
                .map(movieGenre -> Genre.builder().tId(movieGenre.getId()).name(movieGenre.getName()).build())
                .collect(Collectors.toList());

        genres = genres.stream().filter(genre -> !savedGenreTIds.contains(genre.getTId())).collect(Collectors.toList());

        genreRepository.saveAll(genres);
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Long id) {
        return genreRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
