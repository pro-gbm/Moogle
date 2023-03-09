package com.progbm.Moogle.tmdb.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OttResponse {
    private List<Ott> results;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Ott {
        private int displayPriority;
        private String logoPath;
        private String providerName;
        private int providerId;
    }
}
