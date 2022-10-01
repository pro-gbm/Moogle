package com.progbm.Moogle.response;

import com.progbm.Moogle.exception.ErrorCode;
import com.progbm.Moogle.response.dto.BaseResponse;
import com.progbm.Moogle.response.dto.ListDataResponse;
import com.progbm.Moogle.response.dto.SingleDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    /**
     * 단 건 데이터에 대한 API 요청에 대한 응답 메서드
     * @param data
     * @param status
     * @param <T>
     * @return
     */
    public <T> SingleDataResponse getSingleDataResponse(T data, HttpStatus status) {
        return SingleDataResponse.setSuccessResponse(data);
    }

    /**
     * 리스트 데이터에 대한 API 요청에 대한 응답 메서드
     * @param data
     * @param status
     * @param <T>
     * @return
     */
    public <T> ListDataResponse getListDataResponse(List<T> data, HttpStatus status) {
        return ListDataResponse.setSuccessResponse(data);
    }

    /**
     * 데이터 리턴이 필요없는 API 요청에 대한 성공 실패 메서드
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
