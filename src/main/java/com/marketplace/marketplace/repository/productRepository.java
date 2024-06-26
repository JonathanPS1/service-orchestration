package com.marketplace.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.model.product;

@Repository
public interface productRepository extends JpaRepository<product, Long> {

}
