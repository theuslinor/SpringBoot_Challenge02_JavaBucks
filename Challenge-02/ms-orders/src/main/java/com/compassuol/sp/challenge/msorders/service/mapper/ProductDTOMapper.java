package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import org.springframework.stereotype.Component;

public class ProductDTOMapper {
    public ProductDTO createProductDTO(Product product) {
        var productDTOCreate = new ProductDTO();

        productDTOCreate.setId(product.getId());
        productDTOCreate.setName(product.getName());
        productDTOCreate.setValue(product.getValue());
        productDTOCreate.setDescription(product.getDescription());

        return productDTOCreate;
    }
}
