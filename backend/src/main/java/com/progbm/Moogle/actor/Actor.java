package com.progbm.Moogle.actor;

import com.progbm.Moogle.nation.Nation;
import com.progbm.Moogle.util.BaseTimeEntity;
import com.progbm.Moogle.util.Gender;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@EqualsAndHashCode(of = {"tmdbId"})
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Actor extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer tmdbId;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nation_id")
    private Nation nation;

    private String thumbnailUrl;

    public void setNation(Nation nation) {
        this.nation = nation;
    }

}
