package com.marketplace.marketplace.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marketplace.marketplace.model.order;

public interface orderRepository extends MongoRepository<order, String> {

}
