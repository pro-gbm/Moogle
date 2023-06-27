package com.progbm.Moogle.genre;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private Integer tmdbId;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<MovieGenre> movieGenres = new ArrayList<>();

    public void addMovieGenre(MovieGenre movieGenre) {
        movieGenres.add(movieGenre);
        movieGenre.updateGenre(this);
    }

    public void deleteMovieGenre(MovieGenre movieGenre) {
        movieGenres.remove(movieGenre);
        movieGenre.updateGenre(null);
    }
}
