package com.marketplace.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.marketplace.model.customer;

public interface customerRepository extends JpaRepository<customer, Long>{

}
