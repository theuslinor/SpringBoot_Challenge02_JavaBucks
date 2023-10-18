package com.compassuol.sp.challenge.msorders.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {

    private ProductServiceRequest productService;

    private AddressClientRequest addressClientRequest;

    private String payment_method;
}
