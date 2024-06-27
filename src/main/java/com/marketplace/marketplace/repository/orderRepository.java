package com.marketplace.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.marketplace.marketplace.model.order;

public interface orderRepository extends MongoRepository<order, String> {
    public boolean existByKodeTransaksi(String kodeTransaksi);

    public List<order> findByKodeTransaksi(String kodeTransaksi);

    public void deleteByKodeTransaksi(String kodeTransaksi);

    @Query("{'kode_pelanggan' : ?0 }") // ?0 indeks parameter pertama
    List<order> findByPelanggan(String kodePelanggan);

    @Query("{'tanggalPembelian' : ?0 }")
    List<order>findByTglPembelian(String tanggalPembelian);
}
