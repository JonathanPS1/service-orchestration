package com.marketplace.marketplace.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketplace.marketplace.model.order;
import com.marketplace.marketplace.repository.orderRepository;

@Controller
@RequestMapping("/order")
public class orderController {
    @Autowired
    private orderRepository or;

    @GetMapping("")
    public @ResponseBody Iterable<order> getOrder() {
        return or.findAll();
    }

    @PostMapping("/addCart")
    public @ResponseBody String addCart(@RequestBody order o, Double harga_barang) {

    }

    @PostMapping("/addOrder")
    public @ResponseBody String addOrder(@RequestBody order o, Double harga_barang) {
        // Mendapatkan tanggal hari ini
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);

        if (o.getPembayaran() >= o.getTotal()) {
            o.setTanggal_pembelian(formattedDate);
            o.setSubtotal(o.getJumlah_barang() * harga_barang);
            o.setTotal(harga_barang);
            or.insert(o);
            return "Pembelian berhasil";
        } else {
            return "Pembelian gagal";
        }
    }

    @PutMapping("/updateOrder/{kode_transaksi}")
    public @ResponseBody String updateOrder(@PathVariable String kode_transaksi, @RequestBody order oBaru,
            Double harga_barang) {
        if (or.existByKodeTransaksi(kode_transaksi)) {
            // Mendapatkan tanggal hari ini
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = today.format(formatter);

            order oLama = or.findByKodeTransaksi(kode_transaksi).getFirst();

            oLama.setKode_transaksi(kode_transaksi);
            oLama.setTanggal_pembelian(formattedDate);
            oLama.setKode_pelanggan(oBaru.getKode_pelanggan());
            oLama.setKode_barang(oBaru.getKode_barang());
            oLama.setJumlah_barang(oBaru.getJumlah_barang());
            oLama.setSubtotal(oBaru.getJumlah_barang() * harga_barang);

            return "Data order berhasil diperbaharui";

            // private Integer jumlah_barang;
            // private Double subtotal;
            // private Double total;
            // private Double pembayaran;
            // private Double kembalian;
        } else {
            return "Data order gagal diperbaharui";
        }
    }

    @DeleteMapping("/delete/{kode_transaksi}")
    public @ResponseBody String deleteUser (@PathVariable String kode_transaksi){
        if(or.existByKodeTransaksi(kode_transaksi)){
            or.deleteByKodeTransaksi(kode_transaksi);
            return "Berhasil menghapus pembelian";
        }
        else {
            return "Gagal menghapus pembelian";
        }
    }
}
