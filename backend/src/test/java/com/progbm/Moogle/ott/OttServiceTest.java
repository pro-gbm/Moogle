package com.progbm.Moogle.ott;

import com.progbm.Moogle.movie.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OttServiceTest {

    @Autowired
    private OttService ottService;
    @Test
    @DisplayName("OTT 조회 테스트")
    @Transactional
    public void OttsTest() {
        // given
        List<Ott> otts= ottService.Otts();
        // when
        System.out.println("otts = " + otts.toString());
    }
}
