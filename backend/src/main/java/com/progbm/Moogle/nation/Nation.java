package com.progbm.Moogle.nation;

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
public class Nation extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nation;

    private String nationCode;

    private String continent;

}
