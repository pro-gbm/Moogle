package com.progbm.Moogle.config;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptConfigTest {

    @Autowired
    @Qualifier("jasyptStringEncryptor")
    public StringEncryptor encryptor;

    @Value("${spring.datasource.username}")
    private String username;

    @Test
    @DisplayName("암호화 테스트")
    void jasyptTest() {
        String decodedTxt = encryptor.decrypt("R8KQRatusCygy4pmV23ZyQ==");

        Assertions.assertThat(decodedTxt).isEqualTo("root");
        Assertions.assertThat(username).isEqualTo("root");

    }

}