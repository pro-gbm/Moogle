package com.progbm.Moogle.tmdb.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovieOttResponse {

    private int id;
    private List<Nation> results;

    @Data
    public static class Nation {
        private NationOtt KR;
    }

    @Data
    public static class NationOtt {
        private String link;
        private List<OttResponse.Ott> flatrate;
    }
}
