package com.progbm.Moogle.tmdb.response;

import lombok.Data;

import java.util.List;

@Data
public class PopularMovieResponse {

    private int page;
    private List<PopularMovie> results;
    private int totalPages;
    private int totalResults;

    @Data
    public static class PopularMovie {
        private boolean adult;
        private String backdropPath;
        private List<Integer> genreIds;
        private int id;
        private String originalLanguage;
        private String originalTitle;
        private String overview;
        private Double popularity;
        private String posterPath;
        private String releaseDate;
        private String title;
        private boolean video;
        private Double voteAverage;
        private int voteCount;
    }
}
