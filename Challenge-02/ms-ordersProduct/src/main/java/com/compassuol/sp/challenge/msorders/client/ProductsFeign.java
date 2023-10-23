package com.compassuol.sp.challenge.msorders.client;

import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/products",name = "MsProduct")
public interface ProductsFeign {
    @GetMapping("/{id}")
    ProductService getProductsById(@PathVariable Long id);

    @GetMapping
    ProductService getAll();
}
