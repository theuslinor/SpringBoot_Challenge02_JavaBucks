package com.compassuol.sp.challenge.msorders.service;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductMapper;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final ProductDTOMapper productDTOMapper;


    public List<ProductDTO> getAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            ProductDTO productDTO = productDTOMapper.createProductDTO(product);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    public Product updateProduct(Long id, ProductDTO productDTO){
        Product product = productMapper.createProduct(productDTO);
        product.setId(id);
        return productRepository.save(product);
    }

    public Product createProduct(ProductDTO productDTO){
        Product product = productMapper.createProduct(productDTO);
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
