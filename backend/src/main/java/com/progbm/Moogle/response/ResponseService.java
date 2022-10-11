package com.progbm.Moogle.response;

import com.progbm.Moogle.exception.ErrorCode;
import com.progbm.Moogle.response.dto.BaseResponse;
import com.progbm.Moogle.response.dto.DataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    /**
     * API 요청에 대한 데이터를 포함한 응답 메서드
     * @param data
     * @param status
     * @param <T>
     * @return
     */
    public <T> DataResponse getSingleDataResponse(T data, HttpStatus status) {
        return DataResponse.setSuccessResponse(data);
    }

    /**
     * 데이터 리턴이 필요없는 API 요청에 대한 성공 응답 메서드
     */
    public BaseResponse getSuccessResponse() {
        return BaseResponse.setSuccessResponse();
    }

    /**
     * 데이터 리턴이 필요없는 API 요청에 대한 실패 응답 메서드
     */
    public BaseResponse getFailResponse(ErrorCode code) {
        return BaseResponse.setFailResponse(code);
    }
}
