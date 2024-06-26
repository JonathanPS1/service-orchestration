package com.marketplace.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.marketplace.model.product;

public interface productRepository extends JpaRepository<product, Long> {
}