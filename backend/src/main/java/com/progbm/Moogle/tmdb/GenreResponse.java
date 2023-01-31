package com.progbm.Moogle.tmdb;

import lombok.Data;

import java.util.List;

@Data
public class GenreResponse {

    List<MovieGenre> genres;

    @Data
    public static class MovieGenre {
        private int id;
        private String name;
    }
}
