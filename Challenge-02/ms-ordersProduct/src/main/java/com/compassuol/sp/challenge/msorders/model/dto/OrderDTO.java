package com.compassuol.sp.challenge.msorders.model.dto;

import com.compassuol.sp.challenge.msorders.enums.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enums.Status;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    @NotNull
    @JoinColumn(name = "product_id")
    private ProductService productService;

    @NotNull
    @JoinColumn(name = "address_id")
    private AddressClient address;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NotNull
    private Double subtotal_value;

    @NotNull
    private Double discount;

    @NotNull
    private Double total_value;

    @NotNull
    private LocalDateTime date;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotBlank
    private String cancelReason;

    @NotBlank
    private String cancelDate;

}
