/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restoranoop;

public class DetailPesanan {
    private Menu menu;
    private int jumlah;

    public DetailPesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public Menu getMenu() { return menu; }
    public int getJumlah() { return jumlah; }

    public double getSubtotal() {
        return menu.hitungHarga(jumlah);
    }
}