package com.progbm.Moogle.tmdb;

import com.progbm.Moogle.tmdb.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.print.attribute.standard.Media;
import java.util.List;

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
     * TMDB API 에서 지원하는 국가 정보를 가져온다.
     * @return
     */
    public List<NationResponse> getNations() {
        return webClient.mutate()
                .baseUrl(API_URL)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/configuration/countries")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .queryParam("page", 1).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<NationResponse>>() {})
                .block();
    }

    /**
     * TMDB API 에서 지원하는 배우 정보를 가져온다.
     */
    public ActorResponse getActor(int personId) {
        return webClient.mutate()
                .baseUrl(API_URL)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/person/" + personId)
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ActorResponse.class)
                .block();
    }

    /**
     * TMDB API 에서 지원하는 배우 리스트 정보를 가져온다.
     */
    public PopularActorResponse getPopularActor(int page) {
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
                .bodyToMono(PopularActorResponse.class)
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
}