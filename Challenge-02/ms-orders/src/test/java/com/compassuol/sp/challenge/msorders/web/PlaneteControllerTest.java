package com.compassuol.sp.challenge.msorders.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PlaneteControllerTest.class)
@RequiredArgsConstructor
public class PlaneteControllerTest {

    private MockMvc mockMvc;

    @Test
    public void createProduct_WithValidData_ReturnsCreated(){
        mockMvc.perform(post("/products").content())
    }
}
