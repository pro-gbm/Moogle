package com.progbm.Moogle.tmdb.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PopularPersonResponse {

    private int page;
    private List<PopularPerson> results;
    private int totalPages;
    private int totalResults;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class PopularPerson {
        private int id;
        private String name;
        private boolean adult;
        private int gender; // 1: FEMALE, 2: MALE
        private String profilePath; // string or null
        private String knownForDepartment; // Acting, Directing
    }
}
