package com.compassuol.sp.challenge.msorders.model.response;

import com.compassuol.sp.challenge.msorders.enems.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {

    private Long id;

    private Long productId;

    private Double discount;

    private Double total_value;


    private LocalDateTime created_date;

    private Status status;

    private ProductService products;

    private AddressClientResponse addressClientResponse;

    private PaymentMethod payment_method;

    private Double subtotal_value;





}
