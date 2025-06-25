// File: ProductDAO.java
package model;

import java.sql.*; // Penting buat ngurusin koneksi ke database.
import java.util.*; // Buat pake ArrayList dan List.

/**
 * Kelas `ProductDAO` ini adalah jembatan antara aplikasi kita sama database.
 * DAO itu singkatan dari Data Access Object.
 * Jadi, semua operasi yang berhubungan dengan data produk di database (nambah, ngedit, hapus, ambil) diurus di sini.
 * Ini penting banget buat misahin logika bisnis dari logika akses database, biar kode kita rapi.
 */
public class ProductDAO { //
    private Connection conn; // Ini objek buat nyambungin ke database.

    /**
     * Konstruktor `ProductDAO`.
     * Setiap kali kita bikin objek `ProductDAO`, dia langsung nyoba konek ke database.
     * Kalau gagal konek, nanti bakal muncul `SQLException`.
     *
     * @throws SQLException Kalau ada masalah saat koneksi ke database.
     */
    public ProductDAO() throws SQLException { //
        // Ini string koneksi ke database MySQL. Portnya 3307, nama databasenya "aft mart".
        // "root" itu username default, passwordnya kosong.
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", ""); //
    }

    /**
     * Method ini buat nambahin produk baru ke database.
     * ID produk akan otomatis di-generate sama database.
     *
     * @param p Objek `Product` yang mau ditambahin. Bisa `Makanan`, `Minuman`, atau `Kebutuhan`.
     * @throws SQLException Kalau ada error pas eksekusi query SQL-nya.
     */
    public void insertProduct(Product p) throws SQLException { //
        String sql = "INSERT INTO products (name, category, price, stock) VALUES (?, ?, ?, ?)"; // Query SQL buat nambah data.

        PreparedStatement stmt = conn.prepareStatement(sql); // Bikin PreparedStatement biar lebih aman dari SQL Injection.
        stmt.setString(1, p.getNama()); // Set parameter pertama (nama produk).
        stmt.setString(2, p.getKategori()); // Set parameter kedua (kategori produk). Pastiin subclass punya `getKategori()`.
        stmt.setDouble(3, p.getHarga()); // Set parameter ketiga (harga produk).
        stmt.setInt(4, p.getStock()); // Set parameter keempat (stok produk).
        stmt.executeUpdate(); // Eksekusi query INSERT-nya.
    }

    /**
     * Method ini mirip banget sama `insertProduct`, juga buat nambah produk baru.
     * Mungkin ada dua method ini karena beda skenario penggunaan di UI, tapi fungsinya sama.
     *
     * @param p Objek `Product` yang mau ditambahin.
     * @throws SQLException Kalau ada error pas eksekusi query SQL.
     */
    public void addProduct(Product p) throws SQLException { //
        String sql = "INSERT INTO products (name, category, price, stock) VALUES (?, ?, ?, ?)"; //
        PreparedStatement ps = conn.prepareStatement(sql); //
        ps.setString(1, p.getNama()); //
        ps.setString(2, p.getKategori()); //
        ps.setDouble(3, p.getHarga()); //
        ps.setInt(4, p.getStock()); //
        ps.executeUpdate(); //
    }

    /**
     * Method ini buat ngubah (update) data produk yang udah ada di database.
     * Kita butuh ID produknya biar tahu data mana yang mau diubah.
     *
     * @param p Objek `Product` yang berisi data baru (termasuk ID produk yang mau diupdate).
     * @throws SQLException Kalau ada error pas eksekusi query SQL-nya.
     */
    public void updateProduct(Product p) throws SQLException { //
        String sql = "UPDATE products SET name=?, category=?, price=?, stock=? WHERE product_id=?"; // Query SQL buat UPDATE.
        PreparedStatement ps = conn.prepareStatement(sql); //
        ps.setString(1, p.getNama()); // Set nama baru.
        ps.setString(2, p.getKategori()); // Set kategori baru.
        ps.setDouble(3, p.getHarga()); // Set harga baru.
        ps.setInt(4, p.getStock()); // Set stok baru.
        ps.setInt(5, p.getId()); // Ini penting: ID produk yang mau diupdate.
        ps.executeUpdate(); // Eksekusi query UPDATE-nya.
    }

    /**
     * Method ini buat ngehapus produk dari database berdasarkan ID-nya.
     * Hati-hati pake method ini, data bisa hilang permanen!
     *
     * @param id ID produk yang mau dihapus.
     * @throws SQLException Kalau ada error pas eksekusi query SQL-nya.
     */
    public void deleteProduct(int id) throws SQLException { //
        String sql = "DELETE FROM products WHERE product_id=?"; // Query SQL buat DELETE.
        PreparedStatement ps = conn.prepareStatement(sql); //
        ps.setInt(1, id); // Set ID produk yang mau dihapus.
        ps.executeUpdate(); // Eksekusi query DELETE-nya.
    }

    /**
     * Method ini buat mengurangi stok suatu produk di database.
     * Dipake pas ada transaksi pembelian atau barang keluar.
     *
     * @param productId ID produk yang stoknya mau dikurangi.
     * @param jumlahDikurang Berapa banyak stok yang mau dikurangi.
     */
    public void kurangiStok(int productId, int jumlahDikurang) { //
        try { // Blok try-catch buat nangkap error koneksi atau SQL.
            // Koneksi database baru di sini, mungkin lebih baik pakai koneksi yang sudah ada (this.conn) atau pool.
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft_mart", "root", ""); //
            String sql = "UPDATE products SET stock = stock - ? WHERE id = ?"; // Query buat ngurangin stok.
            PreparedStatement ps = conn.prepareStatement(sql); //
            ps.setInt(1, jumlahDikurang); // Berapa banyak yang dikurangin.
            ps.setInt(2, productId); // ID produknya.
            ps.executeUpdate(); // Jalankan query.
            ps.close(); // Tutup PreparedStatement.
            conn.close(); // Tutup koneksi. Ini penting!
        } catch (Exception e) { // Kalau ada error, tangkap di sini.
            System.out.println("Gagal mengurangi stok: " + e.getMessage()); // Cetak pesan error.
        }
    }

    /**
     * Method ini buat ngupdate jumlah stok produk secara langsung dengan nilai baru.
     * Beda sama `kurangiStok`, ini langsung set stoknya jadi angka tertentu.
     *
     * @param id ID produk yang stoknya mau diupdate.
     * @param stokBaru Jumlah stok baru yang akan diset.
     */
    public void updateStok(int id, int stokBaru) { //
        String sql = "UPDATE produk SET stok = ? WHERE id = ?"; // Query SQL buat update stok.
        try ( // Ini try-with-resources, otomatis nutup `conn` dan `stmt` setelah selesai. Keren!
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307:/aft mart", "root", ""); //
             PreparedStatement stmt = conn.prepareStatement(sql)) { //
            stmt.setInt(1, stokBaru); // Set stok baru.
            stmt.setInt(2, id); // Set ID produk.
            stmt.executeUpdate(); // Eksekusi query.
        } catch (SQLException e) { // Kalau ada error SQL, tangkap di sini.
            e.printStackTrace(); // Cetak stack trace biar gampang debug.
        }
    }

    /**
     * Method ini juga buat mengurangi stok, mirip `kurangiStok`.
     * Sepertinya ini duplikasi, mungkin nanti bisa dipilih salah satu yang paling pas.
     * Ini mengembalikan boolean untuk menandakan berhasil atau tidak.
     *
     * @param productId ID produk yang stoknya mau dikurangi.
     * @param quantity Berapa banyak kuantitas yang mau dikurangi.
     * @return `true` kalau berhasil mengurangi stok, `false` kalau gagal.
     */
    public boolean kurangiStock(int productId, int quantity) { //
        // Implementasi untuk mengurangi stok di database.
        System.out.println("Mengurangi stok produk ID " + productId + " sebanyak " + quantity); // Pesan log sementara.
        // Anda perlu mengganti ini dengan kode nyata yang berinteraksi dengan database.
        return true; // Asumsi berhasil untuk kompilasi sementara.
    }

    /**
     * Method ini buat ngambil SEMUA data produk dari database.
     * Nanti hasilnya dikumpulin dalam bentuk `List` of `Product`.
     * Penting buat nampilin daftar produk di GUI.
     *
     * @return `List` yang berisi semua objek `Product` (bisa `Makanan`, `Minuman`, `Kebutuhan`).
     * @throws SQLException Kalau ada error pas ngambil data dari database.
     */
    public List<Product> getAllProducts() throws SQLException { //
        List<Product> list = new ArrayList<>(); // Bikin ArrayList kosong buat nampung produk.
        String sql = "SELECT * FROM products"; // Query buat ngambil semua data dari tabel `products`.
        Statement stmt = conn.createStatement(); // Bikin Statement.
        ResultSet rs = stmt.executeQuery(sql); // Eksekusi query, hasilnya di `ResultSet`.

        while (rs.next()) { // Loop selama masih ada baris data di ResultSet.
            // Ambil data dari setiap kolom.
            String kategori = rs.getString("category"); //
            String nama = rs.getString("name"); //
            double harga = rs.getDouble("price"); //
            int stok = rs.getInt("stock"); //
            int id = rs.getInt("product_id"); //

            Product p = null; // Bikin variabel Product, awalnya null.
            // Cek kategorinya, terus bikin objek `Product` yang sesuai (Makanan, Minuman, atau Kebutuhan).
            if (kategori.equals("Makanan")) { //
                p = new Makanan(id, nama, harga, stok); //
            } else if (kategori.equals("Minuman")) { //
                p = new Minuman(id, nama, harga, stok); //
            } else if (kategori.equals("Kebutuhan")) { //
                p = new Kebutuhan(id, nama, harga, stok); //
            }

            if (p != null) { // Kalau objek `p` nggak null (berarti kategorinya dikenali).
                p.setId(id); // Set ID-nya (meskipun di konstruktor sudah ada, ini buat jaga-jaga).
                list.add(p); // Tambahin objek produk ke dalam list.
            }
        }
        return list; // Balikin list semua produk.
    }

    /**
     * Method ini PENTING BANGET buat nutup koneksi ke database.
     * Kalau nggak ditutup, bisa boros resource dan bikin masalah di kemudian hari.
     * Pastiin selalu dipanggil setelah selesai berinteraksi dengan database.
     *
     * @throws SQLException Kalau ada error saat nutup koneksi.
     */
    public void close() throws SQLException { //
        if (conn != null && !conn.isClosed()) { // Cek dulu koneksinya ada apa nggak dan udah ketutup apa belum.
            conn.close(); // Tutup koneksi.
        }
    }
}
