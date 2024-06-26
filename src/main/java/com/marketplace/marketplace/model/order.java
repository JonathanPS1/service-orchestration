package com.marketplace.marketplace.model;

import jakarta.persistence.Id;

public class order {
    @Id
    private String id;

    private String kode_transaksi;
    private String tanggal_pembelian;
    private String kode_pelanggan;
    private String kode_barang;
    private Integer jumlah_barang;
    private Double subtotal;
    private Double total;
    private Double pembayaran;
    private Double kembalian;
}
