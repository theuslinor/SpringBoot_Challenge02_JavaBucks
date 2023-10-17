package com.compassuol.sp.challenge.msorders.web;

import com.compassuol.sp.challenge.msorders.controller.ProductController;
import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCTDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    void getAllProducts_ReturnsListOfProducts() throws Exception {

        List<ProductDTO> productDTOList = Arrays.asList(new ProductDTO(1L, "tayday",0.0, "jogo da fazendinha"),
        new ProductDTO(2L,"freefire",0.0,"jogo de tiro"));

        when(productService.getAll()).thenReturn(productDTOList);

        MvcResult result = mockMvc.perform(get("/products"))
        .andExpect(status().isOk())
        .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        List<ProductDTO> responseProducts = objectMapper.readValue(responseBody, new TypeReference<List<ProductDTO>>() {});

        assertEquals(2, responseProducts.size());
        assertEquals("tayday", responseProducts.get(0).getName());
        assertEquals("freefire", responseProducts.get(1).getName());
    }

    @Test
    void getAllProducts_ReturnsListEmpty(){
        when(productService.getAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> result = productService.getAll();
        assertThat(result).isEmpty();
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


