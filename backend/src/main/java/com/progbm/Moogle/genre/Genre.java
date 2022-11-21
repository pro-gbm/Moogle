package com.progbm.Moogle.genre;

import com.progbm.Moogle.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Genre extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tId;

    private String name;

//    private Movie movie;

//    private Drama drama;

}
