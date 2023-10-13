package com.compassuol.sp.challenge.msorders.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND("Data Not Found"),

    BAD_REQUEST("Invalid Data"),

    CONFLICT("Conflict between the fields"),

    SYSTEM_ERROR("Unavailable Server");

    private final String message;
}
