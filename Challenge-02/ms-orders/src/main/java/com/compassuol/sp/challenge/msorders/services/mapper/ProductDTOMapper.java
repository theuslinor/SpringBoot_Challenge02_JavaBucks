package com.compassuol.sp.challenge.msorders.services.mapper;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOMapper {
    public ProductDTO createProductDTO(Product product) {
        var productCreate = new ProductDTO();

        productCreate.setId(product.getId());
        productCreate.setName(product.getName());
        productCreate.setValue(product.getValue());
        productCreate.setDescription(product.getDescription());

        return productCreate;
    }
}
