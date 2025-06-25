// File: Kebutuhan.java
package model;

// Subclass: Kebutuhan.java
/**
 * Kelas `Kebutuhan` ini juga anak (subclass) dari kelas `Product`, sama kayak `Makanan` dan `Minuman`.
 * Dia spesialisasinya buat produk-produk kategori "Kebutuhan Sehari-hari".
 * Konsepnya lagi-lagi inheritance, jadi dia otomatis dapet properti dan method dari `Product`.
 */
public class Kebutuhan extends Product { //
    /**
     * Konstruktor ini dipake kalau kita bikin objek `Kebutuhan` yang udah punya ID.
     * Biasanya datanya diambil dari database.
     *
     * @param id ID unik dari produk kebutuhan ini.
     * @param nama Nama produknya, misal "Sabun Mandi".
     * @param harga Harga per satuan produknya.
     * @param stock Jumlah stok produk kebutuhan yang tersedia.
     */
    public Kebutuhan(int id, String nama, double harga, int stock) { //
        super(id, nama, harga, stock); // Manggil konstruktor `Product` dengan semua parameter.
    }

    /**
     * Konstruktor ini dipakai kalau kita mau bikin objek `Kebutuhan` BARU tanpa ID.
     * Cocok buat nambahin produk kebutuhan baru lewat GUI, nanti ID-nya diurus sama database.
     *
     * @param nama Nama produk kebutuhan.
     * @param harga Harga per satuan produknya.
     * @param stock Jumlah stok awal produknya.
     */
    public Kebutuhan(String nama, double harga, int stock) { //
        super(nama, harga, stock); // Manggil konstruktor `Product` yang nggak pake ID.
    }

    /**
     * Method ini wajib di-override dari kelas `Product` karena dia abstrak.
     * Fungsinya buat ngasih tau kalau produk ini masuk kategori "Kebutuhan".
     * Penting buat membedakan jenis-jenis produk dalam sistem.
     *
     * @return Mengembalikan String "Kebutuhan", menunjukkan kategori produk ini.
     */
    @Override // Ini penanda bahwa method ini menimpa method dari kelas induk.
    public String getKategori() { //
        return "Kebutuhan"; //
    }
}