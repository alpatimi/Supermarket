// File: Makanan.java
package model;

/**
 * Sama kayak `Minuman`, `Makanan` ini juga anak (subclass) dari kelas `Product`.
 * Fungsinya spesifik buat data produk yang kategorinya "Makanan".
 * Ini juga contoh dari inheritance, si `Makanan` otomatis mewarisi sifat-sifat dari `Product`.
 */
public class Makanan extends Product { //
    /**
     * Konstruktor ini dipake kalau kita bikin objek `Makanan` yang udah punya ID.
     * Biasanya ini dari data yang udah ada di database.
     *
     * @param id ID unik dari produk makanan ini.
     * @param nama Nama makanannya, contoh "Nasi Goreng".
     * @param harga Harga per satuan makanannya.
     * @param stock Jumlah stok makanan yang tersedia.
     */
    public Makanan(int id, String nama, double harga, int stock) { //
        super(id, nama, harga, stock); // Manggil konstruktor `Product` dengan ID, nama, harga, dan stok.
    }

    /**
     * Ini konstruktor khusus buat nambahin produk makanan baru TANPA ID.
     * Cocok buat GUI kalau user input data produk baru, ID-nya nanti diurus sama database.
     *
     * @param nama Nama makanannya.
     * @param harga Harga per satuan makanannya.
     * @param stock Jumlah stok awal makanannya.
     */
    public Makanan(String nama, double harga, int stock) { //
        super(nama, harga, stock); // Manggil konstruktor `Product` yang nggak pake ID.
    }

    /**
     * Method ini wajib banget di-override dari `Product` karena dia abstrak.
     * Fungsinya buat ngasih tau kalau produk ini masuk kategori "Makanan".
     * Jadi, kita bisa bedain jenis-jenis produk meskipun semuanya di-handle sebagai `Product`.
     *
     * @return Mengembalikan String "Makanan", menunjukkan kategori produk ini.
     */
    @Override // Ini penanda bahwa method ini menimpa method dari kelas induk.
    public String getKategori() { //
        return "Makanan"; //
    }
}