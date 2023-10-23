package com.compassuol.sp.challenge.msfeedback.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class FeedBackNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;

    private final HttpStatus status;

    public FeedBackNotFoundException() {
        super(ErrorCode.NOT_FOUND.name());
        this.status = HttpStatus.NOT_FOUND;
        this.errorCode = ErrorCode.NOT_FOUND;
    }
}
