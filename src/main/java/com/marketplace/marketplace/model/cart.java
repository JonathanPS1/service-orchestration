package com.marketplace.marketplace.model;

import org.springframework.data.annotation.Id;

public class cart {
    @Id
    private String id;

    private String kode_keranjang;
    private String kode_barang;
    private Integer jumlah_barang;
    private Double subtotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode_keranjang() {
        return kode_keranjang;
    }

    public void setKode_keranjang(String kode_keranjang) {
        this.kode_keranjang = kode_keranjang;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public Integer getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(Integer jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
