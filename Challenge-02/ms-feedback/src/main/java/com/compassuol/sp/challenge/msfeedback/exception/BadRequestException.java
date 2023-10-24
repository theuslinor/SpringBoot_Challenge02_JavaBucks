package com.compassuol.sp.challenge.msfeedback.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class BadRequestException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;

    private final HttpStatus status;

    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST.name());
        this.status = HttpStatus.BAD_REQUEST;
        this.errorCode = ErrorCode.BAD_REQUEST;
    }
}
