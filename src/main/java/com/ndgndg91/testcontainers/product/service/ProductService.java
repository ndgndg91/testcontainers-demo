package com.ndgndg91.testcontainers.product.service;

import com.ndgndg91.testcontainers.product.Product;
import com.ndgndg91.testcontainers.product.controller.dto.request.CreateProductRequest;
import com.ndgndg91.testcontainers.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Product create(final CreateProductRequest request) {
        final var product = request.toProduct();
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }
}
