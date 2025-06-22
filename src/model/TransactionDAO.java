package model;

import java.sql.*;
import java.util.List;

public class TransactionDAO {
    private Connection conn;

    public TransactionDAO() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", "");
    }

    public void insertTransaction(int userId, Cart cart) throws Exception {
        String insertTransactionSQL = "INSERT INTO transactions(user_id, total_price) VALUES(?, ?)";
        String insertItemSQL = "INSERT INTO transaction_items(transaction_id, product_id, quantity, subtotal) VALUES(?, ?, ?, ?)";

        try {
            conn.setAutoCommit(false);

            // insert ke transactions
            PreparedStatement pst1 = conn.prepareStatement(insertTransactionSQL, Statement.RETURN_GENERATED_KEYS);
            pst1.setInt(1, userId);
            pst1.setDouble(2, cart.getTotalPrice());
            pst1.executeUpdate();

            // ambil transaction_id
            ResultSet rs = pst1.getGeneratedKeys();
            int transactionId = 0;
            if (rs.next()) {
                transactionId = rs.getInt(1);
            }

            // insert ke transaction_items
            PreparedStatement pst2 = conn.prepareStatement(insertItemSQL);
            for (CartItem item : cart.getItems()) {
                pst2.setInt(1, transactionId);
                pst2.setInt(2, item.getProduct().getId());
                pst2.setInt(3, item.getQuantity());
                pst2.setDouble(4, item.getSubtotal());
                pst2.addBatch();
            }
            pst2.executeBatch();

            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public void close() throws Exception {
        if (conn != null) conn.close();
    }
}

