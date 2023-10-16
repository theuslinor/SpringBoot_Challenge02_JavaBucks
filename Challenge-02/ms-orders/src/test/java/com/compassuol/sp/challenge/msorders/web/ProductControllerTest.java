package com.compassuol.sp.challenge.msorders.web;

import com.compassuol.sp.challenge.msorders.controller.ProductController;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import com.compassuol.sp.challenge.msorders.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCTDTO;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ProductService productService;
    ProductRepository productRepository;


    @Test
    void createProduct_WithValidData_ReturnsCreated() throws Exception{
        when(productService.createProduct(PRODUCTDTO)).thenReturn(PRODUCTDTO);

        mockMvc.perform(post("/products").content(objectMapper.writeValueAsString(PRODUCTDTO))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
        //.andExpect(jsonPath("$").value(PRODUCTDTO));

    }

    @Test
    public void createProduct_WithInvalidData_ReturnsBadRequest() throws Exception {
        ProductDTO emptyProduct = new ProductDTO();
        ProductDTO invalidProduct = new ProductDTO(-1L,"", -1.0, "");

        mockMvc
            .perform(
                post("/products").content(objectMapper.writeValueAsString(emptyProduct))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
        mockMvc
            .perform(
                post("/products").content(objectMapper.writeValueAsString(invalidProduct))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void createProduct_WithExistingName_ReturnsConflict() throws Exception {
        when(productService.createProduct(any())).thenThrow(DataIntegrityViolationException.class);

        mockMvc
        .perform(
        post("/products").content(objectMapper.writeValueAsString(PRODUCTDTO))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isConflict());
    }

    @Test
    public void delete_WithValidData_ReturnNoContent() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        productService.delete(1L);

        assertTrue(productRepository.findById(1L).isEmpty());
    }

    @Test
    public void delete_WithInvalidData_Return() {
        when(productRepository.findById(1l)).thenReturn(Optional.empty());

        var response = productRepository.delete(1L);

        assertEquals(404, response.getStatusCode().value());
    }
}
