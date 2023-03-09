package com.progbm.Moogle.movie;

import com.progbm.Moogle.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"tmdbId"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tmdbId;

    private String title;

    private LocalDateTime openingDate;

    private Double score;

    private Integer attendance;

    private String thumbnailUrl;

    @Column(length = 1000)
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> movieGenres = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "movie")
    private List<MovieOtt> movieOtts = new ArrayList<>();

    public void addMovieGenre(MovieGenre movieGenre) {
        movieGenres.add(movieGenre);
        movieGenre.updateMovie(this);
    }

    public void deleteMovieGenre(MovieGenre movieGenre) {
        movieGenres.remove(movieGenre);
        movieGenre.updateMovie(null);
    }
}
