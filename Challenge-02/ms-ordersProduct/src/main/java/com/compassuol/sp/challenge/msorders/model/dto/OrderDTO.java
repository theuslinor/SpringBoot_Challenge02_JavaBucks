package com.compassuol.sp.challenge.msorders.model.dto;

import com.compassuol.sp.challenge.msorders.model.productService.ProductService;
import com.compassuol.sp.challenge.msorders.model.AddressClient.AddressClient;
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
    private ProductService productService;

    @NotNull
    private AddressClient address;

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
