package com.marketplace.marketplace.service;

import com.marketplace.marketplace.model.product;
import com.marketplace.marketplace.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class productService {
    @Autowired
    private productRepository productRepository;

    public product saveProduct(product product) {
        return productRepository.save(product);
    }

    public Optional<product> getProduct(Long id) {
        return productRepository.findById(id);
    }
}
