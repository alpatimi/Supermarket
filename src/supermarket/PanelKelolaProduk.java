package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import model.Product;
import model.Makanan;
import model.Minuman;
import model.Kebutuhan;
import model.ProductDAO;


public class PanelKelolaProduk extends javax.swing.JPanel {
    DefaultTableModel model;
    ProductDAO dao;



public void tampilkanDataKeTabel() {
    try {
        List<Product> list = dao.getAllProducts();
        DefaultTableModel model = (DefaultTableModel) tabelProduk.getModel();
        model.setRowCount(0); // reset isi tabel

        for (Product p : list) {
            Object[] row = {
                p.getId(),
                p.getNama(),
                p.getKategori(),
                p.getHarga(),
                p.getStok()
            };
            model.addRow(row);
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Gagal ambil data: " + ex.getMessage());
    }
}


    public PanelKelolaProduk() {
        initComponents();
        loadTable();
        try {
            dao = new ProductDAO();
//            dao.addProduct(new Makanan("Nasi", 10000, 10));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadTable() {
        model = new DefaultTableModel(new String[]{"ID", "Nama", "Kategori", "Harga", "Stock"}, 0);
        tabelProduk.setModel(model);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                Vector<String> data = new Vector<>();
                data.add(rs.getString("product_id"));
                data.add(rs.getString("name"));
                data.add(rs.getString("category"));
                data.add(rs.getString("price"));
                data.add(rs.getString("stock"));
                model.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }
    }

//    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
//        
//    }

    private void tabelProdukMouseClicked(java.awt.event.MouseEvent evt) {
        int baris = tabelProduk.getSelectedRow();
//        idTxt.setText(model.getValueAt(baris, 0).toString());
        nameTxt.setText(model.getValueAt(baris, 1).toString());
        categoryCbx.setSelectedItem(model.getValueAt(baris, 2).toString());
        hargaTxt.setText(model.getValueAt(baris, 3).toString());
        stockTxt.setText(model.getValueAt(baris, 4).toString());
    }

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String name = nameTxt.getText();
        String category = categoryCbx.getSelectedItem().toString();
        String harga = hargaTxt.getText();
        String stock = stockTxt.getText();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", "");
            PreparedStatement pst = conn.prepareStatement("UPDATE products SET name=?, category=?, price=?, stock=? WHERE product_id=?");
            pst.setString(2, name);
            pst.setString(3, category);
            pst.setString(4, harga);
            pst.setString(5, stock);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
            loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal update: " + ex.getMessage());
        }
    }

//    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
//
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", "");
//            PreparedStatement pst = conn.prepareStatement("DELETE FROM products WHERE product_id=?");
//            pst.executeUpdate();
//
//            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
//            loadTable();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Gagal hapus: " + ex.getMessage());
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        nameTxt = new javax.swing.JTextField();
        stockTxt = new javax.swing.JTextField();
        hargaTxt = new javax.swing.JTextField();
        categoryCbx = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelProduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));

        addBtn.setBackground(new java.awt.Color(208, 240, 192));
        addBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Harga");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Category");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Stock");

        updateBtn.setBackground(new java.awt.Color(208, 240, 192));
        updateBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(208, 240, 192));
        deleteBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(208, 240, 192));
        exitBtn.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        exitBtn.setText("EXIT");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        hargaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaTxtActionPerformed(evt);
            }
        });

        categoryCbx.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        categoryCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan", "Minuman", "Kebutuhan" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTxt)
                            .addComponent(stockTxt)
                            .addComponent(hargaTxt)
                            .addComponent(categoryCbx, 0, 205, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(exitBtn)
                    .addComponent(addBtn)
                    .addComponent(updateBtn))
                .addGap(114, 114, 114))
        );

        tabelProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Category", "Stock", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tabelProduk);
        if (tabelProduk.getColumnModel().getColumnCount() > 0) {
            tabelProduk.getColumnModel().getColumn(0).setHeaderValue("Nama");
            tabelProduk.getColumnModel().getColumn(1).setHeaderValue("Category");
            tabelProduk.getColumnModel().getColumn(2).setHeaderValue("Stock");
            tabelProduk.getColumnModel().getColumn(3).setHeaderValue("Harga");
        }

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        exitBtn.addActionListener(e -> {
    try {
        dao.close(); // tutup koneksi database
    } catch (Exception ex) {
        System.out.println("Gagal close koneksi: " + ex.getMessage());
    }
    System.exit(0);
});

    }//GEN-LAST:event_exitBtnActionPerformed

    private void hargaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaTxtActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
//       addBtn.addActionListener(e -> {
    try {
        String nama = nameTxt.getText();
        double harga = Double.parseDouble(hargaTxt.getText());
        int stok = Integer.parseInt(stockTxt.getText());
        String kategori = categoryCbx.getSelectedItem().toString();

        Product p;
        switch (kategori) {
            case "Makanan": p = new Makanan(nama, harga, stok); break;
            case "Minuman": p = new Minuman(nama, harga, stok); break;
            default: p = new Kebutuhan(nama, harga, stok); break;
        }

        dao.addProduct(p);
        JOptionPane.showMessageDialog(null, "Produk berhasil ditambahkan!");
        tampilkanDataKeTabel(); // fungsi untuk refresh JTable
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }




//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", "");
//            PreparedStatement pst = conn.prepareStatement("INSERT INTO products(name, category, price, stock) VALUES (?,?,?,?)");
//            pst.setString(1, name);
//            pst.setString(2, category);
//            pst.setString(3, harga);
//            pst.setString(4, stock);
//            pst.executeUpdate();
//
//            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
//            loadTable();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Gagal: " + ex.getMessage());
//        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
//        deleteBtn.addActionListener(e -> {
    int baris = tabelProduk.getSelectedRow();
    if (baris == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data dulu!");
        return;
    }

    int konfirmasi = JOptionPane.showConfirmDialog(null, "Yakin mau hapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (konfirmasi == JOptionPane.YES_OPTION) {
        try {
            int id = Integer.parseInt(tabelProduk.getValueAt(baris, 0).toString());
            dao.deleteProduct(id);
            JOptionPane.showMessageDialog(null, "Produk berhasil dihapus!");
            tampilkanDataKeTabel();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
//});

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
//        updateBtn.addActionListener(e -> {
        int baris = tabelProduk.getSelectedRow();
        if (baris == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data dulu!");
        return;
    }

    try {
        int id = Integer.parseInt(tabelProduk.getValueAt(baris, 0).toString());
        String nama = nameTxt.getText();
        double harga = Double.parseDouble(hargaTxt.getText());
        int stok = Integer.parseInt(stockTxt.getText());
        String kategori = categoryCbx.getSelectedItem().toString();

        Product p;
        switch (kategori) {
            case "Makanan": p = new Makanan(nama, harga, stok); break;
            case "Minuman": p = new Minuman(nama, harga, stok); break;
            default: p = new Kebutuhan(nama, harga, stok); break;
        }

        p.setId(id);
        dao.updateProduct(p);
        JOptionPane.showMessageDialog(null, "Produk berhasil di-update!");
        tampilkanDataKeTabel();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }


    }//GEN-LAST:event_updateBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelKelolaProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelKelolaProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelKelolaProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelKelolaProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelKelolaProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> categoryCbx;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField hargaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField stockTxt;
    private javax.swing.JTable tabelProduk;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
