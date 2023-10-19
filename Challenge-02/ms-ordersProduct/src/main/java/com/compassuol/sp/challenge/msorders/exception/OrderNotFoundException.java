package com.compassuol.sp.challenge.msorders.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class OrderNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;

    private final HttpStatus status;

    public OrderNotFoundException() {
        super(ErrorCode.NOT_FOUND.name());
        this.status = HttpStatus.NOT_FOUND;
        this.errorCode = ErrorCode.ORDER_UPDATE_NOT_ALLOWED;
    }
}
