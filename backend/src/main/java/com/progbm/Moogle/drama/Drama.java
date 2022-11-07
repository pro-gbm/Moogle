package com.progbm.Moogle.drama;

import com.progbm.Moogle.actor.Actor;
import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.genre.Genre;
import com.progbm.Moogle.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Drama extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tId;

    private String title;

    @ManyToOne
    private Director director;

    @ManyToMany
    private List<Actor> actors;

    @ManyToMany
    private List<Genre> genre;

//    private List<Ott> otts;

    private LocalDateTime openingDate;

    private Integer episode;

    private Integer season;

//    private Nation nation;

    private Double score;

    private Double rating;

    private String thumbnailUrl;


}
