package com.compassuol.sp.challenge.msorders.exception;

import org.springframework.http.HttpStatus;

public class OrderUpdateNotAllowedException extends RuntimeException {

    private final ErrorCode errorCode;

    public OrderUpdateNotAllowedException() {
        super("Order Update Not Allowed");
        this.errorCode = ErrorCode.ORDER_UPDATE_NOT_ALLOWED;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
