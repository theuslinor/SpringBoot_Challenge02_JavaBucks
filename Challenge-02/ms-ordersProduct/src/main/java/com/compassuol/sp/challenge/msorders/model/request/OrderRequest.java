package com.compassuol.sp.challenge.msorders.model.request;

import com.compassuol.sp.challenge.msorders.enems.PaymentMethod;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {

    private ProductServiceRequest productService;

    private AddressClientRequest addressClientRequest;

    private PaymentMethod payment_method;
}
