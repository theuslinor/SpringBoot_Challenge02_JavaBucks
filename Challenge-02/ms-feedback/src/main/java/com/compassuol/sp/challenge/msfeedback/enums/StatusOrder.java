package com.compassuol.sp.challenge.msfeedback.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusOrder {

    @JsonProperty("CONFIRMED")
    CONFIRMED,

    @JsonProperty("SENT")
    SENT,

    @JsonProperty("CANCELED")
    CANCELED,

    @JsonProperty("DELIVERED")
    DELIVERED

}
