/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket;
import supermarket.PanelTambahProduk;
import supermarket.PanelProduk;
import supermarket.PanelLihatProduk;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import model.Kebutuhan;
import model.Makanan;
import model.Minuman;
import model.Product;
//import supermarket.view.PanelTambahProduk; // Jika juga digunakan
import supermarket.RegisterPage;
import supermarket.LoginPage;

/**
 *
 * @author timi
 */
public class MainDashboardFrame extends javax.swing.JFrame {
private PanelProduk panelKelola;

    public MainDashboardFrame() {
        initComponents();
        this.setSize(1070, 600); // Pastikan ukuran frame sudah diset
        this.setLocationRelativeTo(null); // Menempatkan frame di tengah layar
        // Set lokasi pembagi (misalnya sidebar selebar 200 piksel)
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setResizeWeight(0.0); // Agar sidebar tidak ikut berubah ukuran saat frame di-resize
        PanelTambahProduk panelTambah = new PanelTambahProduk();
        mainPanelContent.add(panelTambah, "TambahProductCard");
        CardLayout cl = (CardLayout) mainPanelContent.getLayout();
        cl.show(mainPanelContent, "TambahProdukCard");
        panelKelola = new PanelProduk();
        mainPanelContent.add(panelKelola, "KelolaProdukCard");
//        cl.show(mainPanelContent, "KelolaProdukCard");

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
//    private void initComponents() {
//
//        jSplitPane1 = new javax.swing.JSplitPane();
//        jPanel1 = new javax.swing.JPanel();
//        jLabel1 = new javax.swing.JLabel();
//        btnKelolaPengguna = new javax.swing.JButton();
//        btnKelolaProduk = new javax.swing.JButton();
//        btnLihatProduk = new javax.swing.JButton();
//        btnKelolaTransaksi = new javax.swing.JButton();
//        jButton1 = new javax.swing.JButton();
//        mainPanelContent = new javax.swing.JPanel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jSplitPane1.setDividerLocation(200); // Ini sudah diatur di konstruktor juga, bisa dihapus salah satu. Biarkan saja di sini karena ini generated code.
//
//        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
//
//        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel1.setText("Welcome Admin");
//
//        btnKelolaPengguna.setText("Kelola Pengguna");
//        btnKelolaPengguna.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnKelolaPenggunaActionPerformed(evt);
//            }
//        });
//
//        btnKelolaProduk.setText("Kelola Produk");
//        btnKelolaProduk.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnKelolaProdukActionPerformed(evt);
//            }
//        });
//
//        btnLihatProduk.setText("Lihat Produk");
//        // Tambahkan action listener jika Anda ingin ini berfungsi
//        // btnLihatProduk.addActionListener(new java.awt.event.ActionListener() {
//        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
//        //         btnLihatProdukActionPerformed(evt);
//        //     }
//        // });
//
//        btnKelolaTransaksi.setText("Kelola Transaksi");
//        btnKelolaTransaksi.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnKelolaTransaksiActionPerformed(evt);
//            }
//        });
//
//        jButton1.setText("Log Out");
//        // Tambahkan action listener jika Anda ingin ini berfungsi
//        // jButton1.addActionListener(new java.awt.event.ActionListener() {
//        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
//        //         jButton1ActionPerformed(evt);
//        //     }
//        // });
//
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGap(30, 30, 30)
//                .addComponent(jLabel1)
//                .addContainerGap(38, Short.MAX_VALUE))
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addContainerGap()
//                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(btnKelolaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                            .addComponent(btnKelolaPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                            .addComponent(btnLihatProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
//                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addContainerGap())
//            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                    .addContainerGap()
//                    .addComponent(btnKelolaTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addContainerGap()))
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGap(111, 111, 111)
//                .addComponent(jLabel1)
//                .addGap(47, 47, 47)
//                .addComponent(btnKelolaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(12, 12, 12)
//                .addComponent(btnLihatProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(81, 81, 81)
//                .addComponent(btnKelolaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
//                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
//            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                    .addContainerGap(299, Short.MAX_VALUE)
//                    .addComponent(btnKelolaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addGap(264, 264, 264)))
//        );
//
//        jSplitPane1.setLeftComponent(jPanel1); // Set sidebar sebagai komponen kiri
//
//        mainPanelContent.setLayout(new java.awt.CardLayout()); // Menggunakan CardLayout
//        jSplitPane1.setRightComponent(mainPanelContent); // Set mainPanelContent sebagai komponen kanan
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jSplitPane1)
//        );
//
//        pack(); // Mengemas komponen agar sesuai ukuran preferensi
//        setLocationRelativeTo(null); // Menempatkan frame di tengah layar
//    }// </editor-fold>                        

    // </editor-fold>
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTambahProduk = new javax.swing.JButton();
        btnKelolaProduk = new javax.swing.JButton();
        btnLihatProduk = new javax.swing.JButton();
        btnKelolaTransaksi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        mainPanelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jSplitPane1.setDividerLocation(190);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0, 80
        ));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Admin");

        btnTambahProduk.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        btnTambahProduk.setText("Tambah Produk");
        btnTambahProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahProdukActionPerformed(evt);
            }
        });

        btnKelolaProduk.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        btnKelolaProduk.setText("Kelola Produk");
        btnKelolaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKelolaProdukActionPerformed(evt);
            }
        });

        btnLihatProduk.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        btnLihatProduk.setText("Lihat Produk");
        btnLihatProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatProdukActionPerformed(evt);
            }
        });

        btnKelolaTransaksi.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        btnKelolaTransaksi.setText("Kelola Transaksi");
        btnKelolaTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKelolaTransaksiActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Harrington", 1, 14)); // NOI18N
        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKelolaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTambahProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLihatProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKelolaTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnTambahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKelolaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnLihatProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKelolaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        mainPanelContent.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(mainPanelContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahProdukActionPerformed
        // TODO add your handling code here:
        // 1. Buat instance dari PanelKelolaProduk
    CardLayout cl = (CardLayout) mainPanelContent.getLayout();
    cl.show(mainPanelContent, "KelolaProdukCard");
PanelTambahProduk panelTambah = new PanelTambahProduk();
mainPanelContent.add(panelTambah, "TambahProdukCard");
//Supermarket.view.PanelTambahProduk panelKelola =
//            Supermarket.view.PanelTambahProduk();
 mainPanelContent.removeAll(); // Hapus semua komponen yang ada
        mainPanelContent.add(panelTambah, "TambahProdukCard"); // Tambahkan panel baru dengan nama kartu
        mainPanelContent.revalidate(); // Revalidasi
        mainPanelContent.repaint(); // Repaint

    // 2. Set panelKelola sebagai komponen kanan dari JSplitPane Anda
    // Ganti 'jSplitPane1' dengan nama variabel JSplitPane Anda jika berbeda.
    jSplitPane1.setRightComponent(panelTambah);

    // Opsional: Pastikan JSplitPane memperbarui tampilannya
    jSplitPane1.revalidate(); // Memvalidasi ulang layout
    jSplitPane1.repaint();    // Menggambar ulang komponen
                                                  

    }//GEN-LAST:event_btnTambahProdukActionPerformed

    private void btnKelolaTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelolaTransaksiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnKelolaTransaksiActionPerformed

    private void btnKelolaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelolaProdukActionPerformed
        // TODO add your handling code here:
           CardLayout cl = (CardLayout) mainPanelContent.getLayout();
            cl.show(mainPanelContent, "KelolaProdukCard");
            PanelProduk panelKelola = new PanelProduk();
            mainPanelContent.add(panelKelola, "KelolaProdukCard");
            mainPanelContent.removeAll(); // Hapus semua komponen yang ada
            mainPanelContent.add(panelKelola, "KelolaProdukCard"); // Tambahkan panel baru dengan nama kartu
            mainPanelContent.revalidate(); // Revalidasi
            mainPanelContent.repaint(); // Repaint

    jSplitPane1.setRightComponent(panelKelola);
    jSplitPane1.revalidate(); 
    jSplitPane1.repaint();    
                                                   
    }//GEN-LAST:event_btnKelolaProdukActionPerformed

    private void btnLihatProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatProdukActionPerformed

    // 1. Buat instance dari PanelLihatProduk
    PanelLihatProduk panelLihat = new PanelLihatProduk();

    // 2. Hapus semua komponen yang ada di mainPanelContent
    mainPanelContent.removeAll();

    // 3. Tambahkan panel baru ke mainPanelContent dengan nama kartu
    mainPanelContent.add(panelLihat, "LihatProdukCard");

    // 4. Revalidasi dan repaint mainPanelContent untuk memperbarui tampilan
    mainPanelContent.revalidate();
    mainPanelContent.repaint();

    // 5. Set panelLihat sebagai komponen kanan dari JSplitPane Anda
    jSplitPane1.setRightComponent(panelLihat);

    // Opsional: Pastikan JSplitPane memperbarui tampilannya
    jSplitPane1.revalidate();
    jSplitPane1.repaint();

        
    }//GEN-LAST:event_btnLihatProdukActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          // 1. Opsional: Tampilkan konfirmasi kepada pengguna
    int konfirmasi = JOptionPane.showConfirmDialog(this,
                                                  "Anda yakin ingin Log Out?",
                                                  "Konfirmasi Log Out",
                                                  JOptionPane.YES_NO_OPTION);

    if (konfirmasi == JOptionPane.YES_OPTION) {
        this.dispose(); // 'this' merujuk pada instance MainDashboardFrame saat ini

        // 3. Tampilkan kembali LoginPage
        // Pastikan Anda sudah mengimpor LoginPage di MainDashboardFrame.java
        // import supermarket.LoginPage; // Tambahkan ini di bagian atas jika belum ada
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainDashboardFrame frame = new MainDashboardFrame();
                // Tampilkan frame tersebut
                frame.setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKelolaProduk;
    private javax.swing.JButton btnKelolaTransaksi;
    private javax.swing.JButton btnLihatProduk;
    private javax.swing.JButton btnTambahProduk;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel mainPanelContent;
    // End of variables declaration//GEN-END:variables
}
