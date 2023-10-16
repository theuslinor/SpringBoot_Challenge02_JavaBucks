package com.compassuol.sp.challenge.msorders.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    @NotBlank
    private String paymentMethod;

    @NotNull
    private Double subtotalValue;

    @NotNull
    private Double discount;

    @NotNull
    private Double totalValue;

    private LocalDate date;

    @NotBlank
    private String status;

    @NotBlank
    private String cancelReason;

    @NotBlank
    private String cancelDate;


}
