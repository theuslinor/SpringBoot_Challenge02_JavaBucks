package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.controller.ProductController;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.INVALID_PRODUCT;
import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class ProductServiceTests {

    @InjectMocks
     ProductService productService;

    @Mock
     ProductRepository productRepository;
  
    @Mock
    ProductMapper productMapper;
  
    @Mock
    ProductDTOMapper productDTOMapper;
  
    @Mock
    ProductMapper productMapper;

    ProductController productController;


    @Test
    public void listProducts_ReturnsNoProducts() {
        when(productService.getAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getAll();
        assertThat(result).isEmpty();
    }


   @Test
    public void createProduct_WithValidData_ReturnsProduct() {
        ProductDTO productDTO = productDTOMapper.createProductDTO(PRODUCT);

        Product product = productMapper.createProduct(productDTO);

        assertThat(product).isEqualTo(PRODUCT);
    }

    @Test
    public void GetAllProducts_With_ValidData_ReturnsProductList() {

        List<Product> products = Arrays.asList(
        new Product(1L,"Product 1", 10.0,"Product 1"),
        new Product(2L,"Product 2", 10.0,"Product 2")
        );

        when(productRepository.findAll()).thenReturn(products);
        when(productDTOMapper.createProductDTO(products.get(0))).thenReturn(new ProductDTO(1L,"Product 1", 10.0,"Product 1"));

        List<ProductDTO> productDTOs = productService.getAll();

        assertThat(productDTOs.get(0).getName()).isEqualTo("Product 1");

    }
    @Test
    void getProductsById_With_InvalidId_ReturnsNotFound() {

        Long invalidProductId = INVALID_PRODUCT.getId();
        List<Product> products = Arrays.asList(
        new Product(1L,"Product 1", 10.0,"Product 1"));

        when(productRepository.findById(invalidProductId)).thenReturn(Optional.empty());

        ResponseEntity<ProductDTO> response = productController.getProductsById(invalidProductId);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
