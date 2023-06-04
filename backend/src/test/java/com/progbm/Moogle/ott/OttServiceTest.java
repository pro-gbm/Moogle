package com.progbm.Moogle.ott;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OttServiceTest {

    @Autowired
    private OttService ottService;
    @Test
    @DisplayName("OTT 저장 테스트")
//    @Transactional
    public void OttsSaveTest() {
        // given
        ottService.saveOtts();
        List<Ott> otts = ottService.getOtts();
        // then
        System.out.println(otts.size());
        assertThat(otts.isEmpty());
    }
}
