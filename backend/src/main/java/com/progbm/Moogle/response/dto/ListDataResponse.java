package com.progbm.Moogle.response.dto;

import com.progbm.Moogle.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ListDataResponse<T> extends BaseResponse<T>{

    private List<T> data;

    public static <T> ListDataResponse setSuccessResponse(List<T> data) {
        return ListDataResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK)
                .code(ErrorCode.SUCCESS.getCode())
                .message(ErrorCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> ListDataResponse setFailResponse(List<T> data, ErrorCode errorCode) {
        return ListDataResponse.<T>builder()
                .success(false)
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .data(data)
                .build();
    }
}
