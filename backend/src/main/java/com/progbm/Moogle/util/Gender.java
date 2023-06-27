package com.progbm.Moogle.util;

import java.util.Arrays;

public enum Gender {

    MALE(2), FEMALE(1), ETC(0);

    private int value;

    Gender(int value) {
        this.value = value;
    }

    public static Gender getGender(int value) {
        System.out.println("Gender.getGender");
        System.out.println("value = " + value);
        Gender gender1 = Arrays.stream(Gender.values()).filter(gender ->
                        gender.value == value)
                .findFirst()
                .orElse(ETC);
        System.out.println("gender1 = " + gender1);
        return gender1;
    }
}
