package com.progbm.Moogle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableCaching
@SpringBootApplication
public class MoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoogleApplication.class, args);
	}

}
