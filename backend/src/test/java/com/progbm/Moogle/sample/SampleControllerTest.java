package com.progbm.Moogle.sample;

import lombok.RequiredArgsConstructor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class SampleControllerTest {

    @Autowired
    private MockMvc mvc;

    private final SampleController sampleController;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .standaloneSetup(sampleController)
                .build();
    }

    @Test
    @DisplayName("컨트롤러 샘플 테스트")
    void getSample_성공() throws Exception {
        mvc.perform(get("/sample")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("success").isBoolean())
                .andExpect(jsonPath("code").value("0000"))
                .andExpect(jsonPath("message").value("성공"))
        ;
    }

    @Test
    @DisplayName("호출 샘플 테스트")
    public void getInfoList() {
        String type = "countries";
        String KEY = "09a8d7cf7081c0498661adccde4477fd";
        String result = "";
        try {
            // 페이지 마다 루프를 돌며 값 추출 및 저장
            String apiURL = "https://api.themoviedb.org/3/configuration/" + type + "?api_key=" + KEY;
            URL url = new URL(apiURL);
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = bf.readLine();
            System.out.println(result);

            JSONParser parser = new JSONParser();
            Object obj  = parser.parse(result);
            JSONArray array = new JSONArray();
            array.add(obj);
            System.out.println(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}