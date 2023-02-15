package com.progbm.Moogle.director;

import com.progbm.Moogle.movie.Movie;
import com.progbm.Moogle.util.BaseTimeEntity;
import com.progbm.Moogle.util.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Director extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tmdbId;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @OneToMany(mappedBy = "nation", fetch = FetchType.LAZY)
//    private Nation nation;

    private String thumbnailUrl;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies = new ArrayList<>();

}
