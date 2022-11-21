package com.progbm.Moogle.genre;

import com.progbm.Moogle.movie.MovieGenre;
import com.progbm.Moogle.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Genre extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tId;

    private String name;

    @OneToMany(mappedBy = "genre")
    private List<MovieGenre> movieGenres = new ArrayList<>();

//    private Drama drama;

}
