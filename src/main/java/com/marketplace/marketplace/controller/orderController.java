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
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/addOrder")
    public @ResponseBody boolean addOrder(@RequestBody order o, Double harga_barang) {
        // Mendapatkan tanggal hari ini
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);

        if (o.getPembayaran() >= o.getTotal()) {
            o.setTanggal_pembelian(formattedDate);
            o.setTotal(o.getJumlah_barang() * harga_barang);
            o.setKembalian(o.getPembayaran() - o.getTotal());
            or.insert(o);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/updateOrder/{kode_transaksi}")
    public @ResponseBody boolean updateOrder(@PathVariable String kode_transaksi, @RequestBody order oBaru,
            Double harga_barang) {
        if (or.existByKodeTransaksi(kode_transaksi)) {
            if (oBaru.getPembayaran() >= oBaru.getTotal()) {
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
                oLama.setTotal(oBaru.getJumlah_barang() * harga_barang);
                oLama.setPembayaran(oBaru.getPembayaran());
                oLama.setKembalian(oBaru.getPembayaran() - oBaru.getTotal());

                or.save(oLama);

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @DeleteMapping("/delete/{kode_transaksi}")
    public @ResponseBody String deleteUser(@PathVariable String kode_transaksi) {
        if (or.existByKodeTransaksi(kode_transaksi)) {
            or.deleteByKodeTransaksi(kode_transaksi);
            return "Berhasil menghapus pembelian";
        } else {
            return "Gagal menghapus pembelian";
        }
    }

    @PostMapping("/getpelanggan")
    public @ResponseBody Iterable<order> getPelanggan (@RequestParam String kode_pelanggan) {
        return or.findByPelanggan(kode_pelanggan);
    }
}
