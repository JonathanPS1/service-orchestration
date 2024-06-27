package com.marketplace.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marketplace.marketplace.model.order;

public interface orderRepository extends MongoRepository<order, String> {
    public boolean existByKodeTransaksi(String kode_transaksi);

    public List<order> findByKodeTransaksi(String kode_transaksi);
}
