package com.compassuol.sp.challenge.msorders.controller;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
