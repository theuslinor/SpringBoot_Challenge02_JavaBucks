package com.compassuol.sp.challenge.msorders.web;

import com.compassuol.sp.challenge.msorders.controller.ProductController;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCTDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ProductService productService;

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
    public void updateProductName_WithExistingName_ReturnsConflict() throws Exception {
        when(productService.updateProduct(anyLong(), any(ProductDTO.class))).thenThrow(DataIntegrityViolationException.class);
        mockMvc.perform(put("/products/{productId}", 1)
                        .content(objectMapper.writeValueAsString(PRODUCTDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }


}
