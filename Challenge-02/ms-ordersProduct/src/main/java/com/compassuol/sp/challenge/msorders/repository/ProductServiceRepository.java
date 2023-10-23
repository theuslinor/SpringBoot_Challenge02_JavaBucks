package com.compassuol.sp.challenge.msorders.repository;

import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceRepository extends JpaRepository<ProductService, Long> {
}
