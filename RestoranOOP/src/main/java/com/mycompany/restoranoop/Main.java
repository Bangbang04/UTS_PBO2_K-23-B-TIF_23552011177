/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restoranoop;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Tampilkan daftar menu dari database
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM menu");
            ArrayList<Menu> daftarMenu = new ArrayList<>();
            System.out.println("=== Daftar Menu ===");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                double harga = rs.getDouble("harga");
                String jenis = rs.getString("jenis");
                Menu m;
                if (jenis.equalsIgnoreCase("Makanan")) {
                    m = new Makanan(id, nama, harga);
                } else {
                    m = new Minuman(id, nama, harga);
                }
                daftarMenu.add(m);
                System.out.println(id + ". " + nama + " (" + jenis + ") - Rp" + harga);
            }

            // Input pesanan
            System.out.print("No Meja: ");
            int meja = sc.nextInt();
            Pesanan pesanan = new Pesanan(0, meja, "Belum Bayar");

            String lanjut;
            do {
                System.out.print("ID Menu: ");
                int idMenu = sc.nextInt();
                System.out.print("Jumlah: ");
                int jumlah = sc.nextInt();

                Menu menuDipilih = null;
                for (Menu m : daftarMenu) {
                    if (m.id == idMenu) {
                        menuDipilih = m;
                        break;
                    }
                }
                if (menuDipilih != null) {
                    pesanan.tambahDetail(new DetailPesanan(menuDipilih, jumlah));
                } else {
                    System.out.println("ID Menu tidak ditemukan!");
                }
                System.out.print("Tambah lagi? (y/n): ");
                lanjut = sc.next();
            } while (lanjut.equalsIgnoreCase("y"));

            // Tampilkan rincian dan total bayar
            System.out.println("\n--- Rincian Pesanan ---");
            for (DetailPesanan dp : pesanan.getDetailPesananList()) {
                System.out.println(dp.getMenu().getNama() + " x" + dp.getJumlah() + " = Rp" + dp.getSubtotal());
            }
            System.out.println("-----------------------");
            System.out.println("Total yang harus dibayarkan: Rp" + pesanan.getTotalBayar());

            // Simpan pesanan ke DB
            PreparedStatement ps = conn.prepareStatement("INSERT INTO pesanan(meja, status) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pesanan.getMeja());
            ps.setString(2, pesanan.getStatus());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int pesananId = generatedKeys.getInt(1);
                for (DetailPesanan dp : pesanan.getDetailPesananList()) {
                    PreparedStatement psDet = conn.prepareStatement("INSERT INTO detail_pesanan(pesanan_id, menu_id, jumlah) VALUES (?, ?, ?)");
                    psDet.setInt(1, pesananId);
                    psDet.setInt(2, dp.getMenu().id);
                    psDet.setInt(3, dp.getJumlah());
                    psDet.executeUpdate();
                }
                System.out.println("Pesanan berhasil disimpan!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}