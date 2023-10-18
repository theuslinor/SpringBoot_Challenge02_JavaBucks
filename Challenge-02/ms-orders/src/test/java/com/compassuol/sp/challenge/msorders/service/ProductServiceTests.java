package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.exception.ProductNotFoundException;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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
    ProductDTO productDTO;


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
    public void createProduct_WithValidData_ReturnsProduct() {
        when(productDTOMapper.createProductDTO(any(Product.class)))
        .thenReturn(new ProductDTO(400L, "name", 99.0, "description with more 10 caracters"));

        when(productMapper.createProduct(any(ProductDTO.class)))
        .thenReturn(new Product(400L, "name", 99.0, "description with more 10 caracters"));

        ProductDTO productDTO = productDTOMapper.createProductDTO(new Product(400L, "name", 99.0, "description with more 10 characters"));
        Product product = productMapper.createProduct(productDTO);

        assertThat(product).isEqualTo(new Product(400L, "name", 99.0, "description with more 10 caracters"));
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
    public void getListProducts_ReturnsNoProducts() {
        when(productService.getAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getAll();
        assertThat(result).isEmpty();
    }

    @Test
    public void getAllProducts_With_ValidData_ReturnsProductList() {

        List<Product> products = Arrays.asList(
        new Product(1L, "Product 1", 10.0, "Product 1"),
        new Product(2L, "Product 2", 10.0, "Product 2")
        );

        when(productRepository.findAll()).thenReturn(products);
        when(productDTOMapper.createProductDTO(products.get(0))).thenReturn(new ProductDTO(1L, "Product 1", 10.0, "Product 1"));

        List<ProductDTO> productDTOs = productService.getAll();

        assertThat(productDTOs.get(0).getName()).isEqualTo("Product 1");
    }

    @Test
    void getProductsById_WithValidId_ReturnsProductDTO() {

        Product mockProduct = new Product(1L, "Test Product", 99.99, "Sample Description");
        ProductDTO expectedProductDTO = new ProductDTO(1L, "Test Product", 99.99, "Sample Description");

        Mockito.when(productRepository.findById(mockProduct.getId())).thenReturn(Optional.of(mockProduct));
        Mockito.when(productDTOMapper.createProductDTO(mockProduct)).thenReturn(expectedProductDTO);

        ProductDTO actualProductDTO = productService.getProductsById(mockProduct.getId());

        Mockito.verify(productRepository, Mockito.times(1)).findById(mockProduct.getId());
        Mockito.verify(productDTOMapper, Mockito.times(1)).createProductDTO(mockProduct);

        assertEquals(expectedProductDTO, actualProductDTO);
    }

    @Test
    void getProductsById_WithInvalidId_ThrowsProductNotFoundException() {
        Long invalidProductId = -112213L;

        when(productRepository.findById(invalidProductId)).thenThrow(ProductNotFoundException.class);

        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductsById(invalidProductId);
        });
    }

    @Test
    public void deleteProduct_WithValidId_Success() {
        Long productId = 1L;

        when(productRepository.existsById(productId)).thenReturn(true);
        doNothing().when(productRepository).deleteById(productId);

        productService.delete(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    void updateProduct_WithValidData_ReturnsUpdatedProduct() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(PRODUCT));

        Product updatedProduct = new Product();
        updatedProduct.setId(PRODUCT.getId());
        updatedProduct.setName("Test Product");
        updatedProduct.setDescription("Sample Description");
        updatedProduct.setValue(99.99);

        when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);

        Product result = productService.updateProduct(1L, productDTO);

        assertThat(result).isNotNull();
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void updateProductName_WithExistingName_ReturnsConflict() {

        ProductDTO updateRequestDTO = new ProductDTO();
        updateRequestDTO.setName("Test Product");

        Product existingProduct = new Product(1L, "Test Product", 50.0, "Sample Description");

        when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));

        doThrow(new DataIntegrityViolationException("Product with the same name already exists."))
        .when(productRepository).save(any(Product.class));


        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
            productService.updateProduct(1L, updateRequestDTO);
        });

        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(any(Product.class));
    }


    @Test
    void deleteProduct_WithInvalidId_ThrowsNotFound () {
        Long invalidProductId = -1L;

        assertThrows(ProductNotFoundException.class, () -> productService.delete(invalidProductId));
    }
}
