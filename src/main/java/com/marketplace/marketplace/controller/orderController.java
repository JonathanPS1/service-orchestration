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

        o.setTotal(o.getJumlahBarang() * harga_barang);

        if (o.getPembayaran() >= o.getTotal()) {
            o.setTanggalPembelian(formattedDate);
            o.setKembalian(o.getPembayaran() - o.getTotal());
            or.insert(o);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/updateOrder/{kodeTransaksi}")
    public @ResponseBody boolean updateOrder(@PathVariable String kodeTransaksi, @RequestBody order oBaru,
            Double harga_barang) {
        if (or.existsByKodeTransaksi(kodeTransaksi)) {
            if (oBaru.getPembayaran() >= oBaru.getTotal()) {
                // Mendapatkan tanggal hari ini
                LocalDate today = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = today.format(formatter);

                order oLama = or.findByKodeTransaksi(kodeTransaksi).getFirst();

                oLama.setKodeTransaksi(oBaru.getKodeTransaksi());
                oLama.setTanggalPembelian(formattedDate);
                oLama.setKodePelanggan(oBaru.getKodePelanggan());
                oLama.setKodeBarang(oBaru.getKodeBarang());
                oLama.setJumlahBarang(oBaru.getJumlahBarang());
                oLama.setTotal(oBaru.getJumlahBarang() * harga_barang);
                oLama.setPembayaran(harga_barang);
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

    @DeleteMapping("/delete/{kodeTransaksi}")
    public @ResponseBody String deleteUser(@PathVariable String kodeTransaksi) {
        if (or.existsByKodeTransaksi(kodeTransaksi)) {
            or.deleteByKodeTransaksi(kodeTransaksi);
            return "Berhasil menghapus pembelian";
        } else {
            return "Gagal menghapus pembelian";
        }
    }

    @PostMapping("/getpelanggan")
    public @ResponseBody Iterable<order> getPelanggan(@RequestParam String kodePelanggan) {
        return or.findByPelanggan(kodePelanggan);
    }

    @PostMapping("/gettransaksi")
    public @ResponseBody Iterable<order> getTransaksi(@RequestParam String tanggalPembelian) {
        return or.findByTglPembelian(tanggalPembelian);
    }
}
