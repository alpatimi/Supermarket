// File: TransactionDAO.java
package model;

import java.sql.*; // Penting buat operasi database.
import java.util.List; // Buat List of items di keranjang.

/**
 * Kelas `TransactionDAO` ini tugasnya ngurusin semua hal yang berhubungan sama transaksi (pembelian) di database.
 * Jadi, kalau ada user yang checkout keranjang, data transaksi dan item-itemnya bakal disimpen di sini.
 * Ini juga pake konsep DAO biar rapi dan gampang di-maintain.
 */
public class TransactionDAO { //
    private Connection conn; // Objek buat koneksi ke database.

    /**
     * Konstruktor `TransactionDAO`.
     * Pas dibikin, dia langsung nyoba konek ke database kita.
     *
     * @throws Exception Kalau ada masalah pas koneksi ke database.
     */
    public TransactionDAO() throws Exception { //
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", ""); // Konek ke database "aft mart".
    }

    /**
     * Method ini adalah inti dari kelas ini: buat nyimpen data transaksi dan detail item-itemnya ke database.
     * Dia ngegunain konsep **transaksi database** (begin, commit, rollback) biar data nggak setengah-setengah masuknya.
     * Kalau ada salah satu langkah yang gagal, semua perubahan bakal dibatalin (rollback).
     *
     * @param userId ID user yang melakukan transaksi.
     * @param cart Objek `Cart` yang berisi semua produk dan kuantitasnya yang dibeli.
     * @throws Exception Kalau ada masalah selama proses insert transaksi atau item.
     */
    public void insertTransaction(int userId, Cart cart) throws Exception { //
        // Query SQL buat nyimpen data transaksi utama (ID user, total harga).
        String insertTransactionSQL = "INSERT INTO transactions(user_id, total_price) VALUES(?, ?)"; //
        // Query SQL buat nyimpen detail item per transaksi (ID transaksi, ID produk, kuantitas, subtotal).
        String insertItemSQL = "INSERT INTO transaction_items(transaction_id, product_id, quantity, subtotal) VALUES(?, ?, ?, ?)"; //

        try { // Blok try-catch buat nanganin exception dan rollback.
            conn.setAutoCommit(false); // MATIKAN AUTO-COMMIT! Ini penting buat transaksi.

            // Langkah 1: Insert ke tabel `transactions` (tabel utama transaksi).
            PreparedStatement pst1 = conn.prepareStatement(insertTransactionSQL, Statement.RETURN_GENERATED_KEYS); //
            pst1.setInt(1, userId); // Set user ID.
            pst1.setDouble(2, cart.getTotalPrice()); // Set total harga dari keranjang.
            pst1.executeUpdate(); // Eksekusi insert.

            // Ambil ID transaksi yang baru di-generate.
            ResultSet rs = pst1.getGeneratedKeys(); //
            int transactionId = 0; //
            if (rs.next()) { //
                transactionId = rs.getInt(1); // Ambil ID transaksi.
            }

            // Langkah 2: Insert ke tabel `transaction_items` (detail produk yang dibeli).
            PreparedStatement pst2 = conn.prepareStatement(insertItemSQL); //
            for (CartItem item : cart.getItems()) { // Loop setiap item di keranjang.
                pst2.setInt(1, transactionId); // Set ID transaksi yang baru diambil.
                pst2.setInt(2, item.getProduct().getId()); // Set ID produk dari item.
                pst2.setInt(3, item.getQuantity()); // Set kuantitas produk.
                pst2.setDouble(4, item.getSubtotal()); // Set subtotal item.
                pst2.addBatch(); // Tambahkan ke batch (kumpulan query), biar lebih efisien.
            }
            pst2.executeBatch(); // Eksekusi semua query di batch sekaligus.

            conn.commit(); // Kalau semua langkah berhasil, BARU COMMIT (simpan permanen) ke database.
        } catch (Exception ex) { // Kalau ada error di tengah jalan.
            conn.rollback(); // BATALKAN semua perubahan yang sudah terjadi (ROLLBACK).
            throw ex; // Lemparkan exception-nya lagi biar bisa ditangani di layer atas.
        } finally { // Blok ini selalu dieksekusi, mau ada error atau nggak.
            conn.setAutoCommit(true); // Pastiin AUTO-COMMIT dinyalakan lagi setelah transaksi selesai.
        }
    }

    /**
     * Method ini buat nutup koneksi ke database.
     * Penting banget biar nggak ada resource yang nyangkut.
     *
     * @throws Exception Kalau ada masalah pas nutup koneksi.
     */
    public void close() throws Exception { //
        if (conn != null) conn.close(); // Kalau koneksi ada, tutup.
    }
}