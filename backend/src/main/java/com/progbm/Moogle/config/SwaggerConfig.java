package com.progbm.Moogle.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.port}")
    private int swaggerPort;

    /**
     * 스웨거 API 문서 생성
     */
    @Bean
    public Docket swaggerAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("52.78.118.174:" + swaggerPort)
                .apiInfo(this.swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.progbm.Moogle"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true); // 기본으로 세팅되는 200, 401, 403, 404 메시지 표시
    }

    /**
     * 스웨거 정보
     */
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API Documentation")
                .description("<h1>[Pro-GBM#1]Moogle 프로젝트의 REST API문서입니다.</h1>")
                .version("1.0.0")
                .build();
    }
}
