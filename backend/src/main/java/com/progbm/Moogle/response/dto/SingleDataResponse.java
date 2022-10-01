package com.progbm.Moogle.response.dto;

import com.progbm.Moogle.exception.ErrorCode;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SingleDataResponse<T> extends BaseResponse<T>{

    private T data;

    public static <T> SingleDataResponse setSuccessResponse(T data) {
        return SingleDataResponse.builder()
                .success(true)
                .status(HttpStatus.OK)
                .code(ErrorCode.SUCCESS.getCode())
                .message(ErrorCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> SingleDataResponse setFailResponse(T data, ErrorCode errorCode) {
        return SingleDataResponse.builder()
                .success(false)
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .data(data)
                .build();
    }
}
