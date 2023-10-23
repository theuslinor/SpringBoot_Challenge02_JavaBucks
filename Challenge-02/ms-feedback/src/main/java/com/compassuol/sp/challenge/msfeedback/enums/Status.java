package com.compassuol.sp.challenge.msfeedback.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("Very dissatisfied")
    VERY_DISSATISFIED,

    @JsonProperty("Dissatisfied")
    DISSATISFIED,

    @JsonProperty("Neutral")
    NEUTRAL,

    @JsonProperty("Satisfied")
    SATISFIED,

    @JsonProperty("Very satisfied")
    VERY_SATISFIED
}
