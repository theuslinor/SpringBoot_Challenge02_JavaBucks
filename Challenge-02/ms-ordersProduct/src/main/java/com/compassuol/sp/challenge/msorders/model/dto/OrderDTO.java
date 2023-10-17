package com.compassuol.sp.challenge.msorders.model.dto;

import com.compassuol.sp.challenge.msorders.model.product.Product;
import com.compassuol.sp.challenge.msorders.model.viacep.ViaCep;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    @NotNull
    private Product product;

    @NotNull
    private ViaCep address;

    @NotBlank
    private String paymentMethod;

    @NotNull
    private Double subtotalValue;

    @NotNull
    private Double discount;

    private LocalDateTime date;

    @NotBlank
    private String status;

    @NotBlank
    private String cancelReason;

    @NotBlank
    private String cancelDate;

}
