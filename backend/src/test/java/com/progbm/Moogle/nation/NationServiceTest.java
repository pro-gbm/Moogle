package com.progbm.Moogle.nation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NationServiceTest {

    @Autowired
    private NationService nationService;

    @Test
    @DisplayName("국가 삽입 & 조회 테스트")
    @Transactional
    void insertNationsTest() {
        nationService.insertNations();
    }

    @Test
    void getNationsTest() {
        var list = nationService.getNations();
        assertEquals(list.size() == 0, false);
    }
}