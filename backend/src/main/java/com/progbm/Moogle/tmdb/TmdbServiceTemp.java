package com.progbm.Moogle.tmdb;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import springfox.documentation.spring.web.json.Json;

@Service
public class TmdbServiceTemp {

    void init() {
        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=09a8d7cf7081c0498661adccde4477fd&with_watch_provider=337&watch_region=KR&language=ko";



    }

    public static void main(String[] args) {
        String url = "https://api.themoviedb.org";
        String userApiPath = "/3/movie/top_rated?api_key=09a8d7cf7081c0498661adccde4477fd&with_watch_provider=337&watch_region=KR&language=ko";

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

        DefaultUriBuilderFactory uriBuilder = new DefaultUriBuilderFactory(url);

        ParameterizedTypeReference<Json> responseType = new ParameterizedTypeReference<>() {};


        RestTemplate build = restTemplateBuilder
                .uriTemplateHandler(uriBuilder)
                .defaultHeader("Authorization", "Basic SomeToken")
                .build();

        build.exchange(
                userApiPath,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                responseType
                );
    }

}
