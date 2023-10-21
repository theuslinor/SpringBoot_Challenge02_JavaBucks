package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product createProduct(ProductDTO productDTO) {

        var productCreate = new Product();

        productCreate.setId(productDTO.getId());
        productCreate.setName(productDTO.getName());
        productCreate.setValue(productDTO.getValue());
        productCreate.setDescription(productDTO.getDescription());

        return productCreate;
    }
}
