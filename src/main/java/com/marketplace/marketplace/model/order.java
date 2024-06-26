package com.marketplace.marketplace.model;

import jakarta.persistence.Id;

public class order {
    @Id
    private Integer kode_transaksi;
    private String tanggal_pembelian;
    private Integer kode_pelanggan;
    private Integer kode_barang;
    private Integer jumlah_barang;
    private Double subtotal;
    private Double total;
    private Double pembayaran;
    private Double kembalian;

    public Integer getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(Integer kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public String getTanggal_pembelian() {
        return tanggal_pembelian;
    }

    public void setTanggal_pembelian(String tanggal_pembelian) {
        this.tanggal_pembelian = tanggal_pembelian;
    }

    public Integer getKode_pelanggan() {
        return kode_pelanggan;
    }

    public void setKode_pelanggan(Integer kode_pelanggan) {
        this.kode_pelanggan = kode_pelanggan;
    }

    public Integer getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(Integer kode_barang) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Double pembayaran) {
        this.pembayaran = pembayaran;
    }

    public Double getKembalian() {
        return kembalian;
    }

    public void setKembalian(Double kembalian) {
        this.kembalian = kembalian;
    }
}
