package com.marketplace.marketplace.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marketplace.marketplace.model.customer;

public interface customerRepository extends MongoRepository<customer, String>{

}
