package com.marketplace.marketplace.service;

import com.marketplace.marketplace.model.order;
import com.marketplace.marketplace.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class orderService {
    @Autowired
    private orderRepository orderRepository;

    public order saveOrder(order order) {
        return orderRepository.save(order);
    }

    public Optional<order> getOrder(String id) {
        return orderRepository.findById(id);
    }
}
