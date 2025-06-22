package model;

public class Makanan extends Product {
    public Makanan(int id, String nama, double harga, int stock) {
    super(id, nama, harga, stock);
}   
    // Ini adalah konstruktor baru untuk menambahkan produk tanpa ID (untuk operasi ADD)
public Makanan(String nama, double harga, int stock) {
    super(nama, harga, stock); // Memanggil konstruktor baru di kelas Product
}


    @Override
    public String getKategori() {
        return "Makanan";
    }
}

