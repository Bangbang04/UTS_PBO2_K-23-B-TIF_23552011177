UTS Pemrograman Berorientasi Obyek 2
Mata Kuliah: Pemrograman Berorientasi Obyek 2
Dosen Pengampu: Muhammad Ikhwan Fathulloh
Profil
Nama: Bangbang Ramadhan
NIM: 23552011177
Studi Kasus: restoran
Judul Studi Kasus
Kasir Restoran.

Penjelasan Studi Kasus
Sebuah restoran ingin mengelola proses pemesanan dan pembayaran makanan/minuman secara terkomputerisasi. Seorang kasir akan:
- Melihat daftar menu (makanan & minuman)
- Mencatat pesanan pelanggan (berapa meja, apa saja yang dipesan, berapa jumlahnya)
- Sistem akan menghitung total yang harus dibayarkan
- Seluruh pesanan tersimpan dalam database agar mudah diolah atau direkap

Penjelasan 4 Pilar OOP dalam Studi Kasus
1. Inheritance
Inheritance adalah konsep turunan dari satu kelas ke kelas lain.

Implementasi di Studi Kasus:
- "Kelas ItemMakanan" adalah kelas abstrak yang menjadi dasar untuk menu apapun.
- "Kelas Menu" mewarisi (extends) ItemMakanan, sehingga otomatis punya properti dan method dari ItemMakanan.
- "Kelas Makanan" dan "Minuman" mewarisi kelas Menu.
  Contoh Kodenya 
public abstract class ItemMakanan {}
public class Menu extends ItemMakanan {}
public class Makanan extends Menu {}
public class Minuman extends Menu {}

2. Encapsulation
Encapsulation adalah membungkus data dan method dalam satu unit (class), serta membatasi akses langsung ke data.

Implementasi di Studi Kasus:
- Semua data pesanan, menu, dan detail pesanan di-private atau protected.
- Akses data dilakukan melalui *getter/setter* (misal: getNama(), getHarga()).
- Data pesanan pelanggan (meja, status, daftar pesanan) tidak bisa diubah sembarangan dari luar class.
  Contoh Kodenya:
  private Menu menu;
  private int jumlah;
  private int id;
  private int meja;
  private String status;
  private ArrayList<DetailPesanan> detailPesananList = new ArrayList<>();

3. Polymorphism
Polymorphism adalah kemampuan objek untuk memiliki banyak bentuk, terutama pada method yang sama tapi perilaku berbeda.

Implementasi di Studi Kasus:
- Method hitungHarga(int jumlah) didefinisikan di kelas abstrak ItemMakanan, lalu di-override di kelas anak (Menu).
- Jika nanti ada diskon khusus untuk minuman atau makanan tertentu, method ini bisa di-override lagi di kelas anak tanpa mengubah kode di kelas induk.
  Contoh Kodenya
  public abstract double hitungHarga(int jumlah); // di ItemMakanan
@Override
public double hitungHarga(int jumlah) { // di Menu
    return harga * jumlah;
}

4. Abstract
Abstraction adalah menyembunyikan detail implementasi dan hanya menampilkan fitur penting ke pengguna.

Implementasi di Studi Kasus:
- *ItemMakanan* adalah *kelas abstrak* yang tidak bisa diinstansiasi langsung, hanya berfungsi sebagai cetakan dasar bagi menu-menu restoran.
- Kelas abstrak ini mendefinisikan method abstract hitungHarga, sehingga kelas turunannya wajib mengimplementasikannya.
Contoh Kodenya
public abstract class ItemMakanan {
    public abstract double hitungHarga(int jumlah);
}

Demo Proyek
Github: Github
Youtube: Youtube
