package com.progbm.Moogle.movie;

import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tId;

    private String title;

    private LocalDateTime openingDate;

    private Double score;

    private Integer attendance;

    private String thumbnailUrl;

    // N : 1 관계
//    private Director director;

//    private Nation nation;

    // N : N 관계
//    private List<Actor> actors;

//    private List<Genre> genres;

//    private List<Ott> otts;

}
