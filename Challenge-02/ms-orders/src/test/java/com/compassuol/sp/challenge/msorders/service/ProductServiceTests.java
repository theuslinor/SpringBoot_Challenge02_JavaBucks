package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.controller.ProductController;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductMapper;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
       when(productDTOMapper.createProductDTO(any(Product.class)))
       .thenReturn(new ProductDTO(400L,"name", 99.0, "description with more 10 caracters"));

       when(productMapper.createProduct(any(ProductDTO.class)))
       .thenReturn(new Product(400L,"name", 99.0, "description with more 10 caracters"));

       ProductDTO productDTO = productDTOMapper.createProductDTO(new Product(400L, "name", 99.0, "description with more 10 characters"));
       Product product = productMapper.createProduct(productDTO);

        assertThat(product).isEqualTo(new Product(400L,"name", 99.0, "description with more 10 caracters"));
    }

    @Test
    public void createProduct_WithNullData_ReturnsProduct() {
        when(productDTOMapper.createProductDTO(any(Product.class)))
        .thenReturn(null);

        when(productMapper.createProduct(any(ProductDTO.class)))
        .thenReturn(null);

        ProductDTO productDTO = productDTOMapper.createProductDTO(new Product());
        Product product = productMapper.createProduct(new ProductDTO());

        assertThat(productDTO).isNull();
        assertThat(product).isNull();
    }

    @Test
    public void createProduct_WithInvalidData_ReturnsDefaultValues() {
        when(productDTOMapper.createProductDTO(any(Product.class)))
        .thenReturn(new ProductDTO(null, null, 0.0, ""));

        when(productMapper.createProduct(any(ProductDTO.class)))
        .thenReturn(new Product(null, null, 0.0, ""));

        ProductDTO productDTO = productDTOMapper.createProductDTO(new Product(400L, "name", 0.0, "one thing"));
        Product product = productMapper.createProduct(productDTO);

        assertThat(productDTO.getId()).isNull();
        assertThat(productDTO.getName()).isNull();
        assertThat(productDTO.getValue()).isEqualTo(0.0);
        assertThat(productDTO.getDescription()).isEmpty();

        assertThat(product.getId()).isNull();
        assertThat(product.getName()).isNull();
        assertThat(product.getValue()).isEqualTo(0.0);
        assertThat(product.getDescription()).isEmpty();
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
