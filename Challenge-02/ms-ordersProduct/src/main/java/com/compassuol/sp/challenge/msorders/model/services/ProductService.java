package com.compassuol.sp.challenge.msorders.model.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@Entity(name = "order_product")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @Id
    @Column(name = "product_id")
    private Long id;

    private Long quantity;

    private String name;

    private Double value;

    private String description;

    public ProductService(Long id){
        this.id = id;
    }
}
