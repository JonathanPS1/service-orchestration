package com.marketplace.marketplace.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketplace.marketplace.model.order;
import com.marketplace.marketplace.repository.orderRepository;

@Controller
@RequestMapping(path = "/order")
public class orderController {
    @Autowired
    private orderRepository or;

    @GetMapping("/orders")
    public @ResponseBody Iterable<order> getOrder() {
        return or.findAll();
    }

    @PostMapping("/addOrder")
    public @ResponseBody String addOrder(@RequestBody order o) {
        // Mendapatkan tanggal hari ini
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);

        if (o.getPembayaran() >= o.getTotal()) {
            o.setTanggal_pembelian(formattedDate);
            or.insert(o);
            return "Pembelian berhasil";
        } else {
            return "Pembelian gagal";
        }
    }
}
