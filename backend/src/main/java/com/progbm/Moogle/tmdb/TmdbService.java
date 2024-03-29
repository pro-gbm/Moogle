package com.progbm.Moogle.tmdb;

import com.progbm.Moogle.tmdb.response.GenreResponse;
import com.progbm.Moogle.tmdb.response.OttResponse;
import com.progbm.Moogle.tmdb.response.PopularMovieResponse;
import com.progbm.Moogle.tmdb.response.PopularPersonResponse;
import com.progbm.Moogle.tmdb.response.MovieProviderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class TmdbService {

    private final WebClient webClient;

    private static final String API_URL = "https://api.themoviedb.org/3";
    private static final String API_KEY = "09a8d7cf7081c0498661adccde4477fd";
    private static final String LANGUAGE = "ko-KR";

    /**
     * TMDB API 에서 인기있는 영화 id 목록을 가져온다
     */
    public PopularMovieResponse getPopularMovies(int page) {
        return webClient.mutate()
                .baseUrl(API_URL)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/movie/popular")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .queryParam("page", page).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PopularMovieResponse.class)
                .block();
    }

    /**
     * TMDB API 에서 장르 목록을 가져온다
     */
    public GenreResponse getGenres() {
        return webClient.mutate()
                .baseUrl(API_URL)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/genre/movie/list")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .queryParam("page", 1).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GenreResponse.class)
                .block();
    }

    /**
     * TMDB API 에서 지원하는 유명인(배우, 감독) 리스트 정보를 가져온다.
     */
    public PopularPersonResponse getPopularPerson(int page) {
        return webClient.mutate()
                .baseUrl(API_URL)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/person/popular")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .queryParam("page", page)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PopularPersonResponse.class)
                .block();
    }

    /**
     * TMDB API에 있는 Provider들에 대한 정보를 가져온다.
     */
    public OttResponse getOtts()
    {
        return webClient.mutate()
                .baseUrl(API_URL)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/watch/providers/movie")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(OttResponse.class)
                .block();
    }

    public MovieProviderResponse getMovieProviders(int movieId) {
        try {
            return webClient.mutate()
                    .baseUrl(API_URL)
                    .build()
                    .get()
                    .uri(uriBuilder -> uriBuilder.path("/movie/{movieId}/watch/providers")
                            .queryParam("api_key", API_KEY)
                            .build(movieId))
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(MovieProviderResponse.class)
                    .block();
        } catch (Exception e) {
            return null;
        }
    }
}
