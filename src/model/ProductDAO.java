package model;

import model.Minuman;
import model.Makanan;
import model.Kebutuhan;

import java.sql.*;
import java.util.*;

public class ProductDAO {
    private Connection conn;

    public ProductDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", "");
    }
    
    public void insertProduct(Product p) throws SQLException {
    String sql = "INSERT INTO products (name, category, price, stock) VALUES (?, ?, ?, ?)";

    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, p.getNama());
    stmt.setString(2, p.getKategori()); // pastikan subclass punya getKategori()
    stmt.setDouble(3, p.getHarga());
    stmt.setInt(4, p.getStock());
    stmt.executeUpdate();
}


    public void addProduct(Product p) throws SQLException {
        String sql = "INSERT INTO products (name, category, price, stock) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getNama());
        ps.setString(2, p.getKategori());
        ps.setDouble(3, p.getHarga());
        ps.setInt(4, p.getStock());
        ps.executeUpdate();
    }

    public void updateProduct(Product p) throws SQLException {
        String sql = "UPDATE products SET name=?, category=?, price=?, stock=? WHERE product_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getNama());
        ps.setString(2, p.getKategori());
        ps.setDouble(3, p.getHarga());
        ps.setInt(4, p.getStock());
        ps.setInt(5, p.getId());
        ps.executeUpdate();
    }

    public void deleteProduct(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE product_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    
   public void kurangiStok(int productId, int jumlahDikurang) {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft_mart", "root", "");
        String sql = "UPDATE products SET stock = stock - ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, jumlahDikurang);
        ps.setInt(2, productId);
        ps.executeUpdate();
        ps.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Gagal mengurangi stok: " + e.getMessage());
    }
}

    public void updateStok(int id, int stokBaru) {
    String sql = "UPDATE produk SET stok = ? WHERE id = ?";
    try (
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307:/aft mart", "root", "");  
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, stokBaru);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String kategori = rs.getString("category");
            String nama = rs.getString("name");
            double harga = rs.getDouble("price");
            int stok = rs.getInt("stock");
            int id = rs.getInt("product_id");

            Product p = null;
            if (kategori.equals("Makanan")) {
                p = new Makanan(id, nama, harga, stok);
            } else if (kategori.equals("Minuman")) {
                p = new Minuman(id,nama, harga, stok);
            } else if (kategori.equals("Kebutuhan")) {
                p = new Kebutuhan(id, nama, harga, stok);
            }

            if (p != null) {
                p.setId(id);
                list.add(p);
            }
        }

        return list;
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}

