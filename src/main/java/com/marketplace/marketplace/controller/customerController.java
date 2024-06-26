package com.marketplace.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.marketplace.marketplace.model.customer;
import com.marketplace.marketplace.repository.customerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/customer")
public class customerController {
    @Autowired
    private customerRepository cr;

    @GetMapping("/customer")
    public @ResponseBody Iterable<customer> getMethodName() {
        return cr.findAll();
    }

    @PostMapping("/addCustomer")
    public @ResponseBody String addCustomer(String id, String nama, String email, String alamat, String no_hp) {
        if (id == null || nama == null || email == null || alamat == null || no_hp == null) {
            return "Data customer tidak lengkap";
        } else {
            customer c = new customer();
            c.setId(id);
            c.setNama(nama);
            c.setEmail(email);
            c.setAlamat(alamat);
            c.setNo_hp(no_hp);
            cr.save(c);
            return "Customer berhasil ditambahkan";
        }
    }

    @PostMapping("/updateCustomer")
    public @ResponseBody String updateCustomer(String id, String nama, String email, String alamat, String no_hp) {
        if (id == null) {
            return "ID customer tidak ditemukan";
        } else {
            customer c = cr.findById(id).orElse(null);
            if (c == null) {
                return "Customer tidak ditemukan";
            } else {
                if (nama != null) {
                    c.setNama(nama);
                }
                if (email != null) {
                    c.setEmail(email);
                }
                if (alamat != null) {
                    c.setAlamat(alamat);
                }
                if (no_hp != null) {
                    c.setNo_hp(no_hp);
                }
                cr.save(c);
                return "Customer berhasil diupdate";
            }
        }
    }

    @PostMapping("/deleteCustomer")
    public @ResponseBody String deleteCustomer(String id) {
        if (id == null) {
            return "ID customer tidak ditemukan";
        } else {
            cr.deleteById(id);
            return "Customer berhasil dihapus";
        }
    }
}
