package com.compassuol.sp.challenge.msorders.controller;

import com.compassuol.sp.challenge.msorders.dto.ProductDTO;
import com.compassuol.sp.challenge.msorders.entity.Product;
import com.compassuol.sp.challenge.msorders.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> products = productService.getAll();
        return ResponseEntity.ok(products);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
       ProductDTO productDTO= productService.getProductsById(id);
       return ResponseEntity.ok().body(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO existingProduct = productService.getProductsById(id);
        if (existingProduct == null){
            return ResponseEntity.notFound().build();
        }
        productService.updateProduct(id, productDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO){
        ProductDTO productResponseDTO = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDTO);
    }

    @RequestMapping(value ="/{id}",
            method = RequestMethod.DELETE)
    public void delete (@PathVariable("id") Long id){
        productService.delete(id);
    }

}

