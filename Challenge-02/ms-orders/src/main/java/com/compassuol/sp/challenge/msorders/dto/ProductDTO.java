package com.compassuol.sp.challenge.msorders.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
public class ProductDTO {
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Double value;

    @NotBlank
    @Size(min = 10, message = "The field must have at least 10 characters")
    private String description;

}
