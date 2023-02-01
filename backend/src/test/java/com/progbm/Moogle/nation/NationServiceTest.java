package com.progbm.Moogle.nation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NationServiceTest {

    @Test
    @DisplayName("국가 삽입 & 조회 테스트")
    @Transactional
    void insertNations() {

    }

    @Test
    void getNations() {
    }
}