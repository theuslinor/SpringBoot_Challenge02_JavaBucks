package com.compassuol.sp.challenge.msorders.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND("Data Not Found"),

    BAD_REQUEST("Invalid Data"),

    SYSTEM_ERROR("Unavailable Server"),

    ORDER_UPDATE_NOT_ALLOWED("Order Update Not Allowed");

    private final String message;
}
