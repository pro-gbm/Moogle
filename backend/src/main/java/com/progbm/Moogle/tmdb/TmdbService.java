package com.progbm.Moogle.tmdb;

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
    public PopularMovieResponse getPopularMovies() {
        return webClient.mutate()
                .baseUrl(API_URL)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/movie/popular")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .queryParam("page", 1).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PopularMovieResponse.class)
                .block();
    }
}
