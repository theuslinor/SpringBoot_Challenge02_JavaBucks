package com.compassuol.sp.challenge.msorders.model.services;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "order_product")
public class ProductService {
    @Id
    @Column(name = "product_id")
    private Long id;

    @NotNull
    private Long quantity;

    @NotBlank
    private String name;

    @NotNull
    private Double value;

    @NotBlank
    private String description;
}
