package com.compassuol.sp.challenge.msorders.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @Min(0)
    private Double value;

    @NotBlank
    @Size(min = 10, message = "The field must have at least 10 characters")
    private String description;

    public Product(String name, Double value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

}
