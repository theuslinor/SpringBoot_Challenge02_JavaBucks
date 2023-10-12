package com.compassuol.sp.challenge.msorders.controller;

import com.compassuol.sp.challenge.msorders.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;

    @RequestMapping(value ="/{id}",
        method = RequestMethod.DELETE)
    public void delete (@PathVariable("id") Long id){
        productService.delete(id);
    }

    @RequestMapping(value ="/{id}",
            method = RequestMethod.DELETE)
    public void delete (@PathVariable("id") Long id){
        productService.delete(id);
    }
}
