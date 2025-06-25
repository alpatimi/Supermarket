// File: CartItem.java
package model;

/**
 * Kelas `CartItem` ini mewakili satu baris item di keranjang belanja.
 * Jadi, kalau kita nambahin "Nasi Goreng" 2 porsi, itu dianggap satu `CartItem`.
 * Dia nyimpen informasi tentang produknya (objek `Product`) dan berapa kuantitas yang dibeli.
 */
public class CartItem { //
    private Product product; // Ini objek `Product` yang ada di item keranjang.
    private int quantity; // Ini adalah kuantitas produk yang ditambahkan ke keranjang.

    /**
     * Konstruktor untuk `CartItem`.
     * Pas bikin `CartItem`, kita harus kasih tau produknya apa dan berapa banyak yang dibeli.
     *
     * @param product Objek `Product` yang mau dimasukkin ke item keranjang.
     * @param quantity Jumlah kuantitas dari produk tersebut.
     */
    public CartItem(Product product, int quantity) { //
        this.product = product; // Inisialisasi objek Product.
        this.quantity = quantity; // Inisialisasi kuantitas yang dibeli.
    }

    /**
     * Mengambil objek `Product` yang terkait dengan item keranjang ini.
     *
     * @return Objek `Product`.
     */
    public Product getProduct() { //
        return product; //
    }

    /**
     * Mengambil kuantitas produk di item keranjang ini.
     *
     * @return Kuantitas produk.
     */
    public int getQuantity() { //
        return quantity; //
    }

    /**
     * Menghitung subtotal harga untuk item keranjang ini.
     * Yaitu harga produk dikalikan dengan kuantitasnya.
     *
     * @return Subtotal harga item ini.
     */
    public double getSubtotal() { //
        return product.getHarga() * quantity; //
    }

    /**
     * Mengambil ID produk dari objek `Product` yang ada di item ini.
     * Ini cara yang bagus buat manggil getter dari objek lain yang dienkapsulasi.
     *
     * @return ID produk.
     */
    public int getProductId() { // Ubah getter ini agar mengambil dari objek 'product'.
        return product.getId(); //
    }

    /**
     * Mengambil nama produk dari objek `Product` yang ada di item ini.
     *
     * @return Nama produk.
     */
    public String getNama() { //
        return product.getNama(); //
    }

    /**
     * Mengambil kategori produk dari objek `Product` yang ada di item ini.
     *
     * @return Kategori produk (misal "Makanan", "Minuman").
     */
    public String getKategori() { //
        return product.getKategori(); //
    }

    /**
     * Mengambil harga satuan produk dari objek `Product` yang ada di item ini.
     *
     * @return Harga satuan produk.
     */
    public double getHarga() { //
        return product.getHarga(); //
    }

    /**
     * Ini menghitung total harga untuk item ini di keranjang.
     * Sebenarnya sama dengan `getSubtotal()`. Mungkin bisa dipilih salah satu.
     *
     * @return Total harga item ini (harga * kuantitas).
     */
    public double getTotalHarga() { //
        return product.getHarga() * quantity; //
    }

    /**
     * Mengambil jumlah stok produk.
     * **Catatan**: Method ini namanya `getStock()` tapi mengembalikan `quantity` (kuantitas di keranjang),
     * bukan stok produk yang sebenarnya di gudang. Ini bisa membingungkan,
     * mungkin lebih baik diganti namanya atau divalidasi penggunaannya.
     *
     * @return Kuantitas produk di item keranjang ini (bukan stok dari Product).
     */
    public int getStock(){ //
        return quantity; //
    }

    /**
     * Mengubah kuantitas produk di item keranjang ini.
     *
     * @param quantity Kuantitas baru untuk produk ini di keranjang.
     */
    public void setQuantity(int quantity) { //
        this.quantity = quantity; //
    }
}