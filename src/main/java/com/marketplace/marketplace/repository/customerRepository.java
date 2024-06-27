package com.marketplace.marketplace.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.marketplace.model.customer;

@Repository
public interface customerRepository extends JpaRepository<customer, Long>{
    public List<customer> findByNama(String nama);
}
