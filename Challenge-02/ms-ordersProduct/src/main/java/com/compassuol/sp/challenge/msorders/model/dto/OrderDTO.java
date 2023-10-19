package com.compassuol.sp.challenge.msorders.model.dto;

import com.compassuol.sp.challenge.msorders.enums.Status;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
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
    private Double subtotal_value;

    @NotNull
    private Double discount;

    @NotNull
    private Double total_value;

    @NotNull
    private LocalDateTime date;

    @NotBlank
    private Status status;

    @NotBlank
    private String cancelReason;

    @NotBlank
    private String cancelDate;

}
