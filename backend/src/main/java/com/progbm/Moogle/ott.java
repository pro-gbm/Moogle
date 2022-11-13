package com.progbm.Moogle;

import com.progbm.Moogle.util.BaseTimeEntity;
import com.progbm.Moogle.util.Quality;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ott extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String ott;

    private Integer price;

    private Byte personnel;

    @Enumerated(EnumType.STRING)
    private Quality quality;
}
