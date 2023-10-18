package com.compassuol.sp.challenge.msorders.model.AddressClient.response.services;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "order_product")
public class ProductService {
    @Id
    @Column(name = "product_id")
    private Long id;

    private Long quantity;
}
