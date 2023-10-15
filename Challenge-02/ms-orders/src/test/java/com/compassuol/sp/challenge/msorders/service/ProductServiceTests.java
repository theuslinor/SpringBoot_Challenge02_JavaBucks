package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class ProductServiceTests {

    @InjectMocks
     ProductService productService;

    @Mock
     ProductRepository productRepository;

    @Mock
    ProductDTO productDTOMapper;

    @Mock
     MockMvc mockMvc;
    @Mock
    ProductDTO productDTO;

    @Test
    public void createProduct_WithValidData_ReturnsProduct() {
//        when(productRepository.save(PRODUCT)).thenReturn(PRODUCT);
//
//        Product sut = productService.createProduct(PRODUCTDTO);
//
//        assertThat(sut).isEqualTo(PRODUCT);
    }

}
