package com.progbm.Moogle.ott;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.progbm.Moogle.movie.MovieOtt;
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
public class Ott extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private int providerId;

    private String ott;

    private String thumbnailUrl;

    private Integer price;

    private Byte personnel;

    @JsonIgnore
    @OneToMany(mappedBy = "ott")
    private List<MovieOtt> movieOtts = new ArrayList<>();

    public void addMovieOtt(MovieOtt movieOtt) {
        movieOtts.add(movieOtt);
        movieOtt.updateOtt(this);
    }

    public void deleteMovieOtt(MovieOtt movieOtt) {
        movieOtts.remove(movieOtt);
        movieOtt.updateOtt(null);
    }
}
