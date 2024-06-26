package com.marketplace.marketplace.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.model.order;

@Repository
public interface orderRepository extends MongoRepository<order, String>{

}
