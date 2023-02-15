package com.progbm.Moogle.movie;

import com.progbm.Moogle.director.Director;
import com.progbm.Moogle.nation.Nation;
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
@EqualsAndHashCode(of = {"tId"})
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

    @Column(length = 1000)
    private String description;

    // N : 1 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nation_id")
    private Nation nation;

    // N : N 관계 (1 : N 연관 테이블 매핑)
    @Builder.Default
    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors = new ArrayList<>();

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
