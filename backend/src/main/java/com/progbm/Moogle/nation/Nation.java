package com.progbm.Moogle.nation;

import com.progbm.Moogle.movie.Movie;
import com.progbm.Moogle.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Nation extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nation;

    private String nationCode;

    private String continent;

    @OneToMany(mappedBy = "nation")
    private List<Movie> movies = new ArrayList<>();

}
