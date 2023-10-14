package com.compassuol.sp.challenge.msorders.service;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCT;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCTDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;
    ProductDTO productDTO;
    @BeforeEach
    void setUp(){
        productDTO = new ProductDTO(1L," ",0.0," ");
    }

    @Test
    public void listProducts_ReturnsNoProducts() {
        when(productService.getAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getAll();
        assertThat(result).isEmpty();
    }

    @Test
    public void createProduct_WithValidData_ReturnsProduct() {
//        when(productRepository.save(PRODUCT)).thenReturn(PRODUCT);
//
//        Product sut = productService.createProduct(PRODUCTDTO);
//
//        assertThat(sut).isEqualTo(PRODUCT);
    }

}
