package com.ndgndg91.testcontainers.product.repository;

import com.ndgndg91.testcontainers.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
