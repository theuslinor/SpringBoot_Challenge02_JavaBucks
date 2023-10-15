package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.AbstractStringAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCT;
import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

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
    public void createProduct_WithValidData_ReturnsProduct() {
        ProductDTO productDTO = productDTOMapper.createProductDTO(PRODUCT);

        Product product = productMapper.createProduct(productDTO);

        assertThat(product).isEqualTo(PRODUCT);
    }

    @Test
    public void testGetAllP() {

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
