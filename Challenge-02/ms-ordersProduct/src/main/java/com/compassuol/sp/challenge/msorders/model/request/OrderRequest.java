package com.compassuol.sp.challenge.msorders.model.request;

import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
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
