package com.progbm.Moogle.tmdb.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PopularActorResponse {

    private int page;
    private List<PopularActor> results;
    private int totalPages;
    private int totalResults;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class PopularActor {
        private String profilePath;
        private boolean adult;
        private int id;
        private String name;
        private Double popularity;
    }
}
