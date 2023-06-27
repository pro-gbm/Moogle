package com.progbm.Moogle.exception;

import com.progbm.Moogle.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class ExceptionAdviceTest {

    @Autowired
    private MockMvc mvc;

    private final ResponseService responseService;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .standaloneSetup(ExceptionController.class)
                .setControllerAdvice(new ExceptionAdvice(responseService))
//                .setControllerAdvice(ExceptionAdvice.class)
                .build();
    }

    @Test
    void defaultExceptionTest() throws Exception {
        mvc.perform(get("/exception/default")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("success").isBoolean())
                .andExpect(jsonPath("code").value("500"))
                .andExpect(jsonPath("message").value("서버 오류"))
        ;
    }

}