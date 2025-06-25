package model;
/**
 * Kelas `Minuman` ini adalah anak (subclass) dari kelas `Product`.
 * Dia itu spesialis buat nampung data-data produk yang kategorinya "Minuman".
 * Konsepnya mirip inheritence (pewarisan), jadi `Minuman` otomatis punya semua properti dan method dari `Product`.
 */ 
public class Minuman extends Product {
    /**
     * Konstruktor ini dipakai kalau kita mau bikin objek `Minuman` LENGKAP dengan ID-nya.
     * Biasanya dipake kalau datanya udah ada di database terus mau kita ambil.
     *
     * @param id Ini ID unik untuk minumannya, biar gampang dikenali.
     * @param nama Ini nama minumannya, misal "Es Teh", "Kopi Susu".
     * @param harga Ini harga jual satuannya, berapa rupiah.
     * @param stock Ini jumlah stok minumannya yang tersedia di gudang.
     */
    public Minuman(int id, String nama, double harga, int stock) {
    super(id, nama, harga, stock);// Ini manggil konstruktor dari kelas bapaknya (Product) buat ngisi data dasar.
}
    /**
     * Konstruktor ini dipakai kalau kita mau bikin objek `Minuman` BARU tanpa ID.
     * Biasanya dipake waktu kita mau nambahin produk baru ke database, nanti ID-nya di-generate otomatis sama database.
     *
     * @param nama Ini nama minumannya, misal "Soda Gembira".
     * @param harga Ini harga jual satuannya.
     * @param stock Ini jumlah stok awal minumannya.
     */
    public Minuman(String nama, double harga, int stock) {
    super(nama, harga, stock);
}

/**
     * Ini method wajib yang harus di-override dari kelas `Product` yang abstrak.
     * Gunanya buat ngasih tau kategori dari produk ini, yaitu "Minuman".
     * Jadi, kalau kita punya objek `Product` tapi sebenernya itu `Minuman`, kita bisa tau kategorinya apa.
     *
     * @return Mengembalikan String "Minuman", sebagai kategori produk ini.
     */
    @Override
    public String getKategori() {
        return "Minuman";
    }
}