package com.progbm.Moogle.request;

import lombok.Data;

import java.util.List;

@Data
public class AnswerRequest {

    private List<Long> genres;

    private List<Long> movies;

    private List<Long> directors;

    private List<Long> actors;
}
