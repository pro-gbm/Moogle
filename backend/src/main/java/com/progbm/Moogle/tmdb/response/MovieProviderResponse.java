package com.progbm.Moogle.tmdb.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovieProviderResponse {

    int id;
    private ProviderCountry results;

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Flatrate {
        private String logoPath;
        private int displayPriority;
        private int providerId;
        private String providerName;
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Country {
        private String link;
        private List<Flatrate> flatrate;
    }

    @Data
    public static class ProviderCountry {
        @JsonProperty("KR")
        private Country country;
    }
}
