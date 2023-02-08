package com.progbm.Moogle.tmdb.response;

import lombok.Data;

@Data
public class ActorResponse {

    private String birthday; // string or null
    private int id;
    private String name;
    private int gender; // 1: FEMALE, 2: MALE
    private Double popularity;
    private String profilePath; // string or null

}
