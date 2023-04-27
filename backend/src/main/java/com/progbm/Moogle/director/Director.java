package com.progbm.Moogle.director;

import com.progbm.Moogle.util.BaseTimeEntity;
import com.progbm.Moogle.util.Gender;
import com.progbm.Moogle.util.Provider;
import lombok.*;

import javax.persistence.*;

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

    private String thumbnailUrl;

    @Enumerated(EnumType.STRING)
    private Provider provider;
}
