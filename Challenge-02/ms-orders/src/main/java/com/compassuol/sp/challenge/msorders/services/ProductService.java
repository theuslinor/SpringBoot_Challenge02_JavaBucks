package com.compassuol.sp.challenge.msorders.services;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).get();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setValue(productDTO.getValue());
        return productRepository.save(product);
    }

}
