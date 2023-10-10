package com.compassuol.sp.challenge.msorders.services;

import com.compassuol.sp.challenge.msorders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

}
