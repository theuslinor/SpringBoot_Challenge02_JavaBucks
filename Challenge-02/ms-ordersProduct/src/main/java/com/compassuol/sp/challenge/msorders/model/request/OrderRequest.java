package com.compassuol.sp.challenge.msorders.model.request;

import com.compassuol.sp.challenge.msorders.enums.PaymentMethod;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {

    private ProductServiceRequest productService;

    private AddressClientRequest addressClientRequest;

    private PaymentMethod payment_method;
}
