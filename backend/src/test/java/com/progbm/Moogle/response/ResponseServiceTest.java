package com.progbm.Moogle.response;

import com.progbm.Moogle.exception.ErrorCode;
import com.progbm.Moogle.response.dto.BaseResponse;
import com.progbm.Moogle.response.dto.DataResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResponseServiceTest {

    @Autowired
    private ResponseService responseService;

    @Test
    void 성공_응답_데이터_미포함() {
        BaseResponse response = BaseResponse.setSuccessResponse();

        assertAll(
                () -> assertTrue(response.isSuccess()),
                () -> assertEquals(response.getStatus(), HttpStatus.OK),
                () -> assertEquals(response.getCode(), "0000")
        );
    }

    @Test
    void 실패_응답_데이터_미포함() {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;

        BaseResponse response = BaseResponse.setFailResponse(errorCode);

        assertAll(
                () -> assertFalse(response.isSuccess()),
                () -> assertEquals(response.getStatus(), HttpStatus.INTERNAL_SERVER_ERROR),
                () -> assertEquals(response.getCode(), "500")
        );
    }

    @Test
    void dataResponse_singleData_삽입_성공() {
        String dataA = "data A";

        DataResponse response = DataResponse.setSuccessResponse(dataA);

        assertAll(
                () -> assertTrue(response.isSuccess()),
                () -> assertEquals(response.getStatus(), HttpStatus.OK),
                () -> assertEquals(response.getCode(), "0000"),
                () -> assertThat(response.getData()).isInstanceOf(String.class),
                () -> assertEquals(response.getData(), "data A")
        );
    }

    @Test
    void dataResponse_listData_삽입_썽공() {
        String dataA = "data A";
        String dataB = "data B";
        String dataC = "data C";

        List<String> listData = new ArrayList<>();
        listData.add(dataA);
        listData.add(dataB);
        listData.add(dataC);

        DataResponse response = DataResponse.setSuccessResponse(listData);

        assertAll(
                () -> assertTrue(response.isSuccess()),
                () -> assertEquals(response.getStatus(), HttpStatus.OK),
                () -> assertEquals(response.getCode(), "0000"),
                () -> assertThat(response.getData()).isInstanceOf(List.class)
        );
    }

    @Test
    void dataResponse_setFailResponse() {
        String dataA = "data A";
        ErrorCode errorcode = ErrorCode.INTERNAL_SERVER_ERROR;

        DataResponse response = DataResponse.setFailResponse(dataA, errorcode);

        assertAll(
                () -> assertFalse(response.isSuccess()),
                () -> assertEquals(response.getStatus(), HttpStatus.INTERNAL_SERVER_ERROR),
                () -> assertEquals(response.getCode(), "500"),
                () -> assertThat(response.getData()).isInstanceOf(String.class),
                () -> assertEquals(response.getData(), "data A")
        );
    }

}