package com.progbm.Moogle.response.dto;

import com.progbm.Moogle.exception.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ApiModel(value = "기본 응답 포맷")
public class BaseResponse<T> {

    @ApiModelProperty(value = "요청 성공 여부 (true / false)")
    private boolean success;
    @ApiModelProperty(value = "Http Status (OK, NOT FOUND, ...)")
    private HttpStatus status;
    @ApiModelProperty(value = "응답에 대한 상세 코드")
    private String code;
    @ApiModelProperty(value = "응답에 대한 설명")
    private String message;

    public static BaseResponse setSuccessResponse() {
        return BaseResponse.builder()
                .success(true)
                .status(HttpStatus.OK)
                .code(ErrorCode.SUCCESS.getCode())
                .message(ErrorCode.SUCCESS.getMessage())
                .build();
    }

    public static BaseResponse setFailResponse(ErrorCode errorCode) {
        return BaseResponse.builder()
                .success(false)
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
    }
}
