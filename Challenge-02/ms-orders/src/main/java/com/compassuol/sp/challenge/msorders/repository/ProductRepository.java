package com.compassuol.sp.challenge.msorders.repository;

import com.compassuol.sp.challenge.msorders.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
