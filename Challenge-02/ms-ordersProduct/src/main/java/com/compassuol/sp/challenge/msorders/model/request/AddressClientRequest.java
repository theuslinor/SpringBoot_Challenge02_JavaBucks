package com.compassuol.sp.challenge.msorders.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressClientRequest {
    private Long id;

    private String street;

    private Long number;

    private String zipCode;
}
