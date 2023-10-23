package com.compassuol.sp.challenge.msorders.model.response;


import com.compassuol.sp.challenge.msorders.enums.Status;

import com.compassuol.sp.challenge.msorders.enums.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enums.Status;
import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.request.ProductServiceRequest;

import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse extends OrderDTO{

    private ProductServiceRequest products;

    private AddressClientResponse addressClientResponse;

    private PaymentMethod paymentMethod;

    private Double subtotalValue;

    private Double discount;

    private Double totalValue;

    private LocalDateTime date;

    private Status status;

    @JsonIgnore
    private String cancelReason;

    @JsonIgnore
    private String cancelDate;

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long productId;

    @JsonIgnore
    private Long addressId;
}
