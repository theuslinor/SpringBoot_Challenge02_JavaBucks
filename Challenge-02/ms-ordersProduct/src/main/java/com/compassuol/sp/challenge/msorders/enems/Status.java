package com.compassuol.sp.challenge.msorders.enems;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("CONFIRMED")
    CONFIRMED,

    @JsonProperty("SENT")
    SENT,

    @JsonProperty("CANCELED")
    CANCELED


}
