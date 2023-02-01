package com.progbm.Moogle.tmdb.response;

import lombok.Data;

@Data
public class ActorResponse {

    private String birthday; // string or null --> 나이로 변환하는 로직 필요
    private int id;
    private String name;
    private int gender; // defauly:0, 0 ~ 3
    private Double popularity;
    private String profilePath; // string or null

}
