package com.progbm.Moogle.response.dto;

import com.progbm.Moogle.exception.ErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DataResponse<T> extends BaseResponse<T>{

    @ApiModelProperty(value = "API 요청에 대한 응답 데이터")
    private T data;

    public static <T> DataResponse setSuccessResponse(T data) {
        return DataResponse.builder()
                .success(true)
                .status(HttpStatus.OK)
                .code(ErrorCode.SUCCESS.getCode())
                .message(ErrorCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> DataResponse setFailResponse(T data, ErrorCode errorCode) {
        return DataResponse.builder()
                .success(false)
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .data(data)
                .build();
    }
}