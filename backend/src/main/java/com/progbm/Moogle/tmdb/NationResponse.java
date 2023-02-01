package com.progbm.Moogle.tmdb;

import lombok.Data;

import java.util.List;

@Data
public class NationResponse {
//    private List<NationData> results;
//
//    @Data
//    public static class NationData {
        private String iso_3166_1;
        private String english_name;
        private String native_name;
//    }
}
