package com.progbm.Moogle.ott;

import com.progbm.Moogle.movie.MovieOtt;
import com.progbm.Moogle.util.BaseTimeEntity;
import com.progbm.Moogle.util.Quality;
import lombok.*;

import javax.persistence.*;
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

    private String ott;

    private Integer price;

    private Byte personnel;

    @Enumerated(EnumType.STRING)
    private Quality quality;

    @OneToMany(mappedBy = "ott")
    private List<MovieOtt> movieOtts = new ArrayList<>();
}
