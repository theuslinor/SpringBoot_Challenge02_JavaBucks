package com.compassuol.sp.challenge.msorders.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("CONFIRMED")
    CONFIRMED,

    @JsonProperty("SENT")
    SENT,

    @JsonProperty("CANCELED")
    CANCELED,

    @JsonProperty("DELIVERED")
    DELIVERED

}
