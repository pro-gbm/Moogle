package com.progbm.Moogle.tmdb.response;

import lombok.Data;

import java.util.List;

@Data
public class OttResponse {
    private List<Ott> results;

    @Data
    public static class Ott {
        private int display_priority;
        private String logo_path;
        private String provider_name;
        private int provider_id;
    }
}
