package com.progbm.Moogle.actor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ActorTest {

    @Test
    public void equalsAndHashCodeTest_Success() {
        Actor actor1 = Actor.builder()
                .tmdbId(1)
                .build();

        Actor actor2 = Actor.builder()
                .tmdbId(1)
                .build();

        assertThat(actor1).isEqualTo(actor2);
    }

    @Test
    public void equalsAndHashCodeTest_Fail() {
        Actor actor1 = Actor.builder()
                .tmdbId(1)
                .build();

        Actor actor2 = Actor.builder()
                .tmdbId(2)
                .build();

        assertThat(actor1).isNotEqualTo(actor2);
    }

}