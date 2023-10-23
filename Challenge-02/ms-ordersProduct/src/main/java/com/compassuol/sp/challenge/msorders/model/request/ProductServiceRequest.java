package com.compassuol.sp.challenge.msorders.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductServiceRequest {
    private Long id;
    private Long quantity;
}
