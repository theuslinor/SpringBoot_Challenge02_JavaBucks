package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    ProductDTO productDTO;

    @Mock
    ProductMapper productMapper = new ProductMapper();

    @Mock
    ProductDTOMapper productDTOMapper = new ProductDTOMapper();

    @BeforeEach
    void setUp() {
        productDTO = new ProductDTO(1L, " ", 0.0, " ");
    }


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
    public void updateProduct_WithValidData_ReturnsUpdatedProduct() {
        when(productRepository.existsById(anyLong())).thenReturn(true);
        when(productMapper.createProduct(any(ProductDTO.class))).thenReturn(PRODUCT);
        when(productRepository.save(any(Product.class))).thenReturn(PRODUCT);

        Product updatedProduct = productService.updateProduct(1L, productDTO);
        assertThat(updatedProduct).isNotNull();
        verify(productRepository, times(1)).save(any(Product.class));

    }
}
