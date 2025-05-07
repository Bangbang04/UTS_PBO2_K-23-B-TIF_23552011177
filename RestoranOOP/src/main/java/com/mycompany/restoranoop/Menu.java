/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restoranoop;

public class Menu extends ItemMakanan {
    private String jenis;

    public Menu(int id, String nama, double harga, String jenis) {
        super(id, nama, harga);
        this.jenis = jenis;
    }

    @Override
    public double hitungHarga(int jumlah) {
        return harga * jumlah;
    }

    public String getJenis() { return jenis; }
}