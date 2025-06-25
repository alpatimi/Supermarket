// File: Cart.java
package model;

import java.util.ArrayList; // Buat bikin List yang dinamis.
import java.util.Iterator; // Buat iterasi (looping) item. (Tapi nggak dipake langsung di sini).
import java.util.List; // Tipe data List.

/**
 * Kelas `Cart` ini mewakili keranjang belanja kita.
 * Dia nampung semua `CartItem` yang udah dimasukkin sama user.
 * Di sini ada logika buat nambah, ngurangin, bersihin, dan ngitung total harga keranjang.
 */
public class Cart { //
    // Ini list buat nyimpen item-item yang ada di keranjang. Setiap item itu objek CartItem.
    private List<CartItem> items = new ArrayList<>(); //

    /**
     * Konstruktor default untuk `Cart`.
     * Cuma nge-init `items` sebagai `ArrayList` kosong.
     */
    public Cart(){}; //

    /**
     * Method ini buat nambahin produk ke dalam keranjang.
     * Kalau produknya udah ada di keranjang, dia cuma nambahin kuantitasnya aja.
     * Kalau produknya belum ada, dia bikin `CartItem` baru dan dimasukkin ke keranjang.
     *
     * @param product Objek `Product` yang mau ditambahin ke keranjang.
     * @param quantity Berapa banyak kuantitas produk ini yang mau ditambahin.
     */
    public void addItem(Product product, int quantity) { //
        for (CartItem item : items) { // Loop setiap item yang udah ada di keranjang.
            if (item.getProduct().getId() == product.getId()) { // Kalau ID produknya sama (berarti produk yang sama).
                item.setQuantity(item.getQuantity() + quantity); // Cukup tambahin kuantitasnya.
                return; // Langsung keluar dari method karena udah selesai.
            }
        }
        items.add(new CartItem(product, quantity)); // Kalau produk belum ada, tambahin CartItem baru.
    }

    /**
     * Method ini buat ngapus produk dari keranjang berdasarkan ID produknya.
     *
     * @param productId ID produk yang mau dihapus dari keranjang.
     */
    public void removeItem(int productId) { //
        items.removeIf(item -> item.getProduct().getId() == productId); // Ini cara keren buat ngapus item pake lambda expression.
    }

    /**
     * Method ini buat ngosongin semua isi keranjang.
     * Berguna pas udah selesai checkout atau mau mulai belanja lagi.
     */
    public void clearCart() { //
        items.clear(); // Hapus semua item dari list.
    }

    /**
     * Mengambil daftar semua `CartItem` yang ada di keranjang.
     *
     * @return `List` dari objek `CartItem`.
     */
    public List<CartItem> getItems() { //
        return items; //
    }

    /**
     * Menghitung total harga dari semua item yang ada di keranjang.
     *
     * @return Total harga belanjaan di keranjang.
     */
    public double getTotalPrice() { //
        double total = 0; // Inisialisasi total harga.
        for (CartItem item : items) { // Loop setiap item di keranjang.
            total += item.getSubtotal(); // Tambahin subtotal setiap item ke total.
        }
        return total; // Balikin total harga.
    }
}