/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restoranoop;

import java.util.ArrayList;

public class Pesanan {
    private int id;
    private int meja;
    private String status;
    private ArrayList<DetailPesanan> detailPesananList = new ArrayList<>();

    public Pesanan(int id, int meja, String status) {
        this.id = id;
        this.meja = meja;
        this.status = status;
    }

    public void tambahDetail(DetailPesanan dp) {
        detailPesananList.add(dp);
    }

    public ArrayList<DetailPesanan> getDetailPesananList() {
        return detailPesananList;
    }

    public int getId() { return id; }
    public int getMeja() { return meja; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Method untuk menghitung total bayar
    public double getTotalBayar() {
        double total = 0;
        for (DetailPesanan dp : detailPesananList) {
            total += dp.getSubtotal();
        }
        return total;
    }
}