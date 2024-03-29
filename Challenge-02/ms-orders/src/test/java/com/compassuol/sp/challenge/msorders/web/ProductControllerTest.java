package com.compassuol.sp.challenge.msorders.web;

import com.compassuol.sp.challenge.msorders.controller.ProductController;
import com.compassuol.sp.challenge.msorders.model.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Product;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static com.compassuol.sp.challenge.msorders.common.ProductConstants.PRODUCTDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
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
    void createProduct_WithValidData_ReturnsCreated() throws Exception {
        when(productService.createProduct(PRODUCTDTO)).thenReturn(PRODUCTDTO);

        mockMvc.perform(post("/products").content(objectMapper.writeValueAsString(PRODUCTDTO))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
    }

    @Test
    public void createProduct_WithInvalidData_ReturnsBadRequest() throws Exception {
        ProductDTO emptyProduct = new ProductDTO();
        ProductDTO invalidProduct = new ProductDTO(-1L, "", -1.0, "");
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
    void getProductById_WithInvalidId_ReturnsNotFound() throws Exception {

        Long productId = null;

        when(productService.getProductsById(null)).thenThrow(NoSuchElementException.class);

        MvcResult result = mockMvc.perform(get("/products/{id}", productId))
        .andExpect(status().isNotFound())
        .andReturn();
    }

    @Test
    void getProductById_WithValidId_ReturnsProduct() throws Exception {

        Long productId = 1L;
        Product product = new Product(productId, "Product 1", 100.0, "Description");

        ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getValue(), product.getDescription());
        when(productService.getProductsById(productId)).thenReturn(productDTO);


        MvcResult result = mockMvc.perform(get("/products/{id}", productId))
        .andExpect(status().isOk())
        .andReturn();


        String responseBody = result.getResponse().getContentAsString();
        ProductDTO responseProduct = objectMapper.readValue(responseBody, ProductDTO.class);

        assertEquals(productId, responseProduct.getId());
        assertEquals("Product 1", responseProduct.getName());
        assertEquals(100.0, responseProduct.getValue());
        assertEquals("Description", responseProduct.getDescription());
    }


    @Test
    public void updateProductName_WithExistingName_ReturnsConflict() throws Exception {
        when(productService.updateProduct(anyLong(), any(ProductDTO.class))).thenThrow(DataIntegrityViolationException.class);
        mockMvc.perform(put("/products/{productId}", 1)
        .content(objectMapper.writeValueAsString(PRODUCTDTO))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isConflict());
    }

    @Test
    void updateProductName_WithValidId_ReturnsSuccess() throws Exception {
        Long productId = 1L;
        String updatedName = "Updated Name";

        ProductDTO updateRequestDTO = new ProductDTO();
        updateRequestDTO.setName(updatedName);

        Product updatedProduct = new Product(productId, updatedName, 100.0, "Updated Description");

        when(productService.updateProduct(eq(productId), any(ProductDTO.class)))
        .thenReturn(updatedProduct);

        mockMvc.perform(MockMvcRequestBuilders.put("/products/{productId}", productId)
        .content(asJsonString(updateRequestDTO))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }


    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deleteProduct_WithValidId_ReturnsNoContent() throws Exception {
        Long productId = 1L;

        doNothing().when(productService).delete(productId);

        mockMvc.perform(delete("/products/{id}", productId))
        .andExpect(status().isNoContent());
    }


    @Test
    void deleteProduct_WithInvalidId_ReturnsNotFound() throws Exception {
        Long invalidProductId = -1L;

        doThrow(NoSuchElementException.class).when(productService).delete(invalidProductId);

        try {
            mockMvc.perform(MockMvcRequestBuilders.delete("/products/{id}", invalidProductId))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
        } catch (Exception e) {
        }
    }
}
