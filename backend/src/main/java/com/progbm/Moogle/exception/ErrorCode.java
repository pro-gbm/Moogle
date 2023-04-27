package com.progbm.Moogle.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS(HttpStatus.OK, "0000", "성공"),

    /* 기타 오류 처리 */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500","서버 오류"),
    RUNTIME_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "5001","런타임 오류"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "401","권한 없음"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "403","접근 거부됨"),
    NULL_POINTER_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "5002", "NPE 발생")
    ;


    private final HttpStatus status;
    private final String code;
    private final String message;

}
