package com.progbm.Moogle.movie;

import com.progbm.Moogle.genre.Genre;
import com.progbm.Moogle.genre.GenreRepository;
import com.progbm.Moogle.tmdb.TmdbService;
import com.progbm.Moogle.tmdb.response.MovieOttResponse;
import com.progbm.Moogle.tmdb.response.PopularMovieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    private final TmdbService tmdbService;
    private final MovieRepository movieRepository;
    private final  GenreRepository genreRepository;
    private final MovieGenreRepository movieGenreRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String IMAGE_URL = "https://image.tmdb.org/t/p/original";

    /**
     * TMDB API 에서 인기있는 영화 목록을 가져와서 Movie Entity 로 가공하여 저장
     * @param page
     */
    public void savePopularMovies(int page) {
        // DB 에 저장된 영화 목록 불러와서 tmdbId 목록으로 가공
        Set<Integer> savedMovieTmdbIds = movieRepository.findAll().stream().map(Movie::getTmdbId).collect(Collectors.toSet());
        Map<Integer, List<Integer>> movieGenreMap = new HashMap<>();

        for (int i = 1; i <= page; i++) {
            // 인기 영화 목록 응답을 영화 엔티티 목록으로 가공
            PopularMovieResponse popularMovies = tmdbService.getPopularMovies(page);
            List<Movie> movies = popularMovies.getResults().stream().map(popularMovie -> {
                // popularMovie 의 id 를 키로 장르 목록 저장
                movieGenreMap.put(popularMovie.getId(), popularMovie.getGenreIds());

                // 영화 엔티티 생성 후 리턴
                return Movie.builder()
                        .tmdbId(popularMovie.getId())
                        .title(popularMovie.getTitle())
                        .openingDate(LocalDate.parse(popularMovie.getReleaseDate(), formatter).atStartOfDay())
                        .score(popularMovie.getVoteAverage())
                        .thumbnailUrl(IMAGE_URL + popularMovie.getPosterPath())
                        .description(popularMovie.getOverview())
                        .build();
            }).collect(Collectors.toList());

            // DB 에 이미 저장되어 있는 영화들을 tmdbId 로 확인하여 제외
            movies = movies.stream().filter(movie -> !savedMovieTmdbIds.contains(movie.getTmdbId())).collect(Collectors.toList());

            // 영화 목록 저장
            List<Movie> savedMovies = movieRepository.saveAll(movies);

            // 영화에 매핑된 장르 목록 저장
            savedMovies.forEach(movie -> this.addGenres(movie, movieGenreMap.get(movie.getTmdbId())));
        }
    }

    @Transactional(readOnly = true)
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addGenres(Movie movie, List<Integer> genreIds) {
        if (genreIds == null || genreIds.isEmpty()) {
            return;
        }

        // 장르 id 리스트로 장르 리스트 조회
        List<Genre> genres = genreIds.stream()
                .map(genreId -> genreRepository.findByTmdbId(genreId).orElse(null))
                .filter(genre -> genre != null)
                .collect(Collectors.toList());

        // 영화 장르 엔티티로 만들어서 저장하기
        List<MovieGenre> movieGenres = genres.stream()
                .map(genre -> MovieGenre.builder().movie(movie).genre(genre).build())
                .collect(Collectors.toList());

        movieGenreRepository.saveAll(movieGenres);
    }

    @Transactional
    public void getMovieOtts() {
        // 영화 목록 조회
        List<Integer> movieTmdbIds = movieRepository.findAll().stream().map(Movie::getTmdbId).collect(Collectors.toList());


        MovieOttResponse movieOtts = tmdbService.getMovieOtts(movieTmdbIds.get(0));
        System.out.println("movieOtts = " + movieOtts);
    }
}
