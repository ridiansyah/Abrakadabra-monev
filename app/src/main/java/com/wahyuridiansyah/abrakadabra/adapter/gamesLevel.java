package com.wahyuridiansyah.abrakadabra.adapter;

/**
 * Created by Andri Ginting on 4/2/2017.
 */

public class gamesLevel {
    private String nama;
    private int gambar;

    public gamesLevel() {
    }

    public gamesLevel(String nama, int gambar) {
        this.nama = nama;
        this.gambar=gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
