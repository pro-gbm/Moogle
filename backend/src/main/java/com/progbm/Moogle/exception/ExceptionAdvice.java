package com.progbm.Moogle.exception;

import com.progbm.Moogle.response.ResponseService;
import com.progbm.Moogle.response.dto.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<BaseResponse> baseException(BaseException e) {
        BaseResponse response = responseService.getFailResponse(e.getErrorCode());

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<BaseResponse> defaultException(Exception e) {
        BaseResponse response = responseService.getFailResponse(ErrorCode.INTERNAL_SERVER_ERROR);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<BaseResponse> runtimeException(RuntimeException e) {
        BaseResponse response = responseService.getFailResponse(ErrorCode.RUNTIME_EXCEPTION);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<BaseResponse> nullPointerException(NullPointerException e) {
        BaseResponse response = responseService.getFailResponse(ErrorCode.NULL_POINTER_EXCEPTION);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

}
