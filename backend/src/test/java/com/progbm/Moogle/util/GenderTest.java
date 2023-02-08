package com.progbm.Moogle.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenderTest {

    @Test
    public void getGenderTest() {
        int valueOfMale = 2; // MALE
        int valueOfFemale = 1; // FEMALE

        Gender male = Gender.getGender(valueOfMale);
        Gender female = Gender.getGender(valueOfFemale);

        assertThat(male).isEqualTo(Gender.MALE);
        assertThat(female).isEqualTo(Gender.FEMALE);
    }

}