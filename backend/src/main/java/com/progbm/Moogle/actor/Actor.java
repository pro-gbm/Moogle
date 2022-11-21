package com.progbm.Moogle.actor;

import com.progbm.Moogle.util.BaseTimeEntity;
import com.progbm.Moogle.util.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Actor extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tId;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    private Nation nation;

    private String thumbnailUrl;

}
