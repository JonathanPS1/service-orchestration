package com.marketplace.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.marketplace.marketplace.model.customer;
import com.marketplace.marketplace.repository.customerRepository;

@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private customerRepository cr;

    @GetMapping("/customer")
    public @ResponseBody Iterable<customer> getAllCustomers() {
        return cr.findAll();
    }

    @PostMapping("/addCustomer")
    public @ResponseBody String addCustomer(Long id, String nama, String email, String alamat, String no_hp) {
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
    public @ResponseBody String updateCustomer(Long id, String nama, String email, String alamat, String no_hp) {
        if (id == null || nama == null || email == null || alamat == null || no_hp == null) {
            return "Data customer tidak lengkap";
        } else {
            customer c = cr.findById(id).get();
            c.setNama(nama);
            c.setEmail(email);
            c.setAlamat(alamat);
            c.setNo_hp(no_hp);
            cr.save(c);
            return "Customer berhasil diupdate";
        }
    }

    @PostMapping("/deleteCustomer")
    public @ResponseBody String deleteCustomer(Long id) {
        if (id == null) {
            return "ID customer tidak ditemukan";
        } else {
            cr.deleteById(id);
            return "Customer berhasil dihapus";
        }
    }
}
