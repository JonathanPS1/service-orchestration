package com.marketplace.marketplace.model;

import jakarta.persistence.Id;

public class customer {
    @Id
    private String id;
    private String nama;
    private String email;
    private String alamat;
    private String no_hp;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getNo_hp() {
        return no_hp;
    }
    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }



}
