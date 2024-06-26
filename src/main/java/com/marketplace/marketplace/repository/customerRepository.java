package com.marketplace.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.model.customer;

@Repository
public interface customerRepository extends JpaRepository<customer, Long>{

}
