package com.progbm.Moogle.movie;

import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.PopularMovieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    private final TmdbService tmdbService;
    private final MovieRepository movieRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String IMAGE_URL = "https://image.tmdb.org/t/p/original";

    /**
     * TMDB API 에서 인기있는 영화 목록을 가져와서 Movie Entity 로 가공하여 저장
     * @param page
     */
    public void savePopularMovies(int page) {
        // DB 에 저장된 영화 목록 불러와서 tId 목록으로 가공
        Set<Integer> savedMovieTIds = movieRepository.findAll().stream().map(Movie::getTId).collect(Collectors.toSet());

        for (int i = 1; i <= page; i++) {
            // 인기 영화 목록 응답을 영화 엔티티 목록으로 가공
            PopularMovieResponse popularMovies = tmdbService.getPopularMovies(page);
            List<Movie> movies = popularMovies.getResults().stream().map(popularMovie -> Movie.builder()
                    .tId(popularMovie.getId())
                    .title(popularMovie.getTitle())
                    .openingDate(LocalDate.parse(popularMovie.getReleaseDate(), formatter).atStartOfDay())
                    .score(popularMovie.getVoteAverage())
                    .thumbnailUrl(IMAGE_URL + popularMovie.getPosterPath())
                    .description(popularMovie.getOverview())
                    .build()).collect(Collectors.toList());

            // DB 에 이미 저장되어 있는 영화들을 tId 로 확인하여 제외
            movies = movies.stream().filter(movie -> !savedMovieTIds.contains(movie.getTId())).collect(Collectors.toList());

            // 영화 목록 저장
            movieRepository.saveAll(movies);
        }
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
