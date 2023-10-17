package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.controller.ProductController;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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


    @Test
    public void listProducts_ReturnsNoProducts() {
        when(productService.getAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getAll();
        assertThat(result).isEmpty();
    }


   @Test
    public void createProduct_WithValidData_ReturnsProduct() {
        ProductDTO productDTO = productDTOMapper.createProductDTO(new Product(400L,"name", 99.0, "description with more 10 caracters"));

        Product product = productMapper.createProduct(productDTO);

       //Product product = new Product(400L,"name", 99.0, "description with more 10 caracters");
        assertThat(product).isEqualTo(new Product(400L,"name", 99.0, "description with more 10 caracters"));
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

}
