package com.progbm.Moogle.tmdb.response;

import lombok.Data;

import java.util.List;

@Data
public class PopularActorResponse {

    private int page;
    private List<PopularActor> results;
    private int totalPages;
    private int totalResults;

    @Data
    private static class PopularActor {
        private String profilePath;
        private boolean adult;
        private int id;
        private String name;
        private Double popularity;
//        private List<String> knownForList;
    }
}
