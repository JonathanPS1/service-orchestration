package com.marketplace.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.marketplace.marketplace.model.order;

public interface orderRepository extends MongoRepository<order, String> {
    public boolean existByKodeTransaksi(String kode_transaksi);

    public List<order> findByKodeTransaksi(String kode_transaksi);

    public void deleteByKodeTransaksi(String kode_transaksi);

    @Query("{'kode_pelanggan' : ?0 }") //?0 indeks parameter pertama
    List<order> findByPelanggan(String kode_pelanggan);
}
