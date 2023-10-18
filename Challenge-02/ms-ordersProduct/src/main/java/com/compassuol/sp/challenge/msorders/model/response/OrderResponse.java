package com.compassuol.sp.challenge.msorders.model.response;

import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long id;

    private ProductService products;

    private AddressClientResponse addressClientResponse;

    private String payment_method;

    private Double subtotal_value;

    private Double discount;

    private Double total_value;

    private LocalDateTime created_date;

    private Status status;

}
