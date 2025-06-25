// File: LoginPage.java
package supermarket; // Ini paket (package) tempat kelas ini berada, biar rapi dan nggak tabrakan nama.

// Import-import ini penting biar kita bisa pake fitur-fitur dari library Java yang lain.
import java.sql.Connection; // Buat koneksi ke database.
import java.sql.DriverManager; // Buat ngatur koneksi database.
import java.sql.PreparedStatement; // Buat query SQL yang aman dari SQL Injection.
import java.sql.ResultSet; // Buat nampung hasil dari query SELECT.
import java.sql.SQLException; // Buat nanganin error-error yang berhubungan sama database.
import javax.swing.JOptionPane; // Buat nampilin pop-up pesan ke user (kayak peringatan atau informasi).

/**
 * @author timi
 * Kelas `LoginPage` ini adalah GUI (Graphical User Interface) kita untuk halaman login.
 * Artinya, ini adalah tampilan di mana user bisa masukin username, password, dan pilih role (peran).
 * Dia itu turunan dari `javax.swing.JFrame`, jadi dia adalah sebuah jendela (window) di aplikasi GUI kita.
 * Di sini kita belajar gimana cara menggabungkan GUI dengan operasi database sederhana.
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Ini adalah konstruktor dari kelas `LoginPage`.
     * Setiap kali kita bikin objek `LoginPage` (misalnya pas aplikasi pertama kali jalan),
     * method ini yang bakal dipanggil. Di sini kita inisialisasi komponen-komponen GUI kita.
     */
     public LoginPage() {
        initComponents(); // Ini method otomatis yang dibikin sama NetBeans buat inisialisasi semua komponen visual (tombol, text field, dll.).
        this.setResizable(false); // Biar ukuran jendela login nggak bisa diubah-ubah sama user.
        this.setLocationRelativeTo(null); // Biar jendela login munculnya di tengah layar.
    }

    /**
     * Method ini otomatis digenerate sama GUI Builder (NetBeans).
     * Gunanya buat inisialisasi semua komponen visual (kayak label, text field, tombol, combo box)
     * dan mengatur tata letaknya di dalam frame.
     * WARNING: JANGAN diotak-atik manual kode di dalam `initComponents()` ini,
     * karena kalau diubah bisa rusak desain GUI-nya. Kalau mau ngubah desain, pake GUI Builder-nya NetBeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        roleCombo = new javax.swing.JComboBox<>();
        passwordTxt = new javax.swing.JPasswordField();
        usernameTxt = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        registBtn = new javax.swing.JButton();
        showPw = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Select Role");

        roleCombo.setBackground(new java.awt.Color(204, 153, 255, 80));
        roleCombo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        passwordTxt.setBackground(new java.awt.Color(255, 253, 214));
        passwordTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        usernameTxt.setBackground(new java.awt.Color(255, 253, 214));
        usernameTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        loginBtn.setBackground(new java.awt.Color(255, 253, 214));
        loginBtn.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(51, 51, 51));
        loginBtn.setText("LOGIN");
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        registBtn.setBackground(new java.awt.Color(255, 253, 214));
        registBtn.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        registBtn.setText("Don't Have Account? Register Now");
        registBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registBtnActionPerformed(evt);
            }
        });

        showPw.setBackground(new java.awt.Color(204, 153, 255, 80));
        showPw.setFont(new java.awt.Font("Harrington", 1, 12)); // NOI18N
        showPw.setForeground(new java.awt.Color(255, 255, 255));
        showPw.setText("show password");
        showPw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(roleCombo, 0, 156, Short.MAX_VALUE)
                        .addComponent(usernameTxt)
                        .addComponent(passwordTxt)
                        .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(showPw, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(showPw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 360, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\timi\\OneDrive\\design project.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        setSize(new java.awt.Dimension(1084, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Method ini akan dipanggil otomatis ketika tombol "Register Now" (registBtn) diklik.
     * Fungsinya buat ngebuka halaman registrasi dan nutup halaman login saat ini.
     *
     * @param evt Objek Event yang merepresentasikan aksi klik tombol.
     */
    private void registBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registBtnActionPerformed
        // TODO add your handling code here:
        RegisterPage registerForm = new RegisterPage();
        registerForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registBtnActionPerformed
 /**
     * Method ini akan dipanggil otomatis ketika tombol "LOGIN" (loginBtn) diklik.
     * Ini adalah logika utama untuk proses login:
     * 1. Mengambil input username, password, dan role dari form.
     * 2. Melakukan validasi sederhana (cek input kosong, panjang password).
     * 3. Mencoba koneksi ke database dan mengecek kredensial user.
     * 4. Jika login berhasil, ngebuka dashboard sesuai role user dan nutup jendela login.
     * 5. Jika gagal, nampilin pesan error.
     *
     * @param evt Objek Event yang merepresentasikan aksi klik tombol.
     */
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
 String role = roleCombo.getSelectedItem().toString(); // Ambil role yang dipilih dari combo box.
        String username = usernameTxt.getText(); // Ambil teks username dari text field.
        String password = new String(passwordTxt.getPassword()); // Ambil password dari password field (penting: jangan langsung .getText(), tapi getPassword() lalu ubah ke String).

        // Validasi sederhana input user.
        if(username.isEmpty() || password.isEmpty()){ // Kalau username atau password kosong.
                JOptionPane.showMessageDialog(this, "username dan password tidak boleh kosong"); // Tampilkan pesan peringatan.
                return; // Langsung keluar dari method.
            }
            if (password.length() < 8) { // Kalau panjang password kurang dari 8 karakter.
                JOptionPane.showMessageDialog(null, "Password minimal 8 karakter", "Coba lagi", JOptionPane.WARNING_MESSAGE); // Tampilkan peringatan.
                return; // Langsung keluar dari method.
            }

        try{ // Blok try-catch buat nanganin kemungkinan error saat koneksi atau interaksi database.
            // Langkah 1: Konek ke database.
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/aft mart", "root", ""); // Buka koneksi ke database MySQL.
            // Langkah 2: Bikin query SQL buat ngecek user di tabel 'users'.
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?"; // Query SELECT. "?" itu placeholder buat parameter.
            PreparedStatement pst = conn.prepareStatement(sql); // Bikin PreparedStatement biar lebih aman.
            pst.setString(1, username); // Set parameter pertama dengan username.
            pst.setString(2, password); // Set parameter kedua dengan password.
            ResultSet rs = pst.executeQuery(); // Eksekusi query, hasilnya disimpen di `ResultSet`.

            // Langkah 3: Cek hasil query.
            if(rs.next()){ // Kalau `rs.next()` true, berarti ada data user yang cocok di database.
                String roleFromDB = rs.getString("role"); // Ambil role user dari database.

                // Langkah 4: Arahkan ke dashboard sesuai role.
                // Ini logika untuk memilih dashboard berdasarkan role yang dipilih di combo box dan role dari database.
                if(role.equals("Admin") && roleFromDB.equals("Admin")){ // Kalau user pilih Admin DAN role di DB juga Admin.
                    new MainDashboardFrame().setVisible(true); // Buka dashboard Admin.
                } else if (role.equals("User") && roleFromDB.equals("User")){ // Kalau user pilih User DAN role di DB juga User.
                   new MainDashboardUser().setVisible(true); // Buka dashboard User.
               } else {
                   // Ini kondisi di mana role yang dipilih user di GUI tidak cocok dengan role user di database.
                   JOptionPane.showMessageDialog(null, "Role yang dipilih tidak sesuai dengan akun ini", "Error", JOptionPane.ERROR_MESSAGE);
                   return; // Jangan dispose jendela jika role tidak sesuai.
               }
                this.dispose(); // Nutup jendela login setelah berhasil masuk.
            }else{ // Kalau `rs.next()` false, berarti username/password salah atau user tidak ditemukan.
                JOptionPane.showMessageDialog(null, "Username atau password salah", "Error", JOptionPane.ERROR_MESSAGE); // Tampilkan pesan error.
            }
        }catch(SQLException e){ // Kalau ada error SQL (misal koneksi database putus).
            JOptionPane.showMessageDialog(this, "Login Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Tampilkan pesan error SQL.
        }
    }//GEN-LAST:event_loginBtnActionPerformed
 /**
     * Method ini akan dipanggil otomatis ketika checkbox "show password" (showPw) diklik.
     * Fungsinya buat nampilin atau nyembunyiin karakter password di `passwordTxt` field.
     *
     * @param evt Objek Event yang merepresentasikan aksi klik checkbox.
     */
    private void showPwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPwActionPerformed
        // TODO add your handling code here:
        if (showPw.isSelected()){ // Kalau checkbox-nya dicentang.
            passwordTxt.setEchoChar((char)0); // Tampilkan karakter asli password (0 = karakter null).
        }else{ // Kalau checkbox-nya nggak dicentang.
            passwordTxt.setEchoChar('*'); // Sembunyikan karakter password dengan tanda bintang.
        }
    }//GEN-LAST:event_showPwActionPerformed

/**
     * Ini adalah method `main`, titik awal eksekusi program kita.
     * Saat aplikasi dijalankan, method inilah yang pertama kali dipanggil.
     * Di sini kita cuma bikin objek `LoginPage` dan menampilkannya.
     *
     * @param args Argumen baris perintah (jarang dipakai di aplikasi GUI sederhana).
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    try { // Blok try-catch ini buat nanganin error kalau ada masalah sama tampilan GUI (look and feel).
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) { // Coba cari look and feel "Nimbus" (tampilan modern).
                        javax.swing.UIManager.setLookAndFeel(info.getClassName()); // Kalau ketemu, pake Nimbus.
                        break; // Keluar dari loop.
                    }
                }
            } catch (ClassNotFoundException ex) { // Kalau kelas look and feel nggak ketemu.
                java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) { // Kalau ada masalah pas bikin instance look and feel.
                java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) { // Kalau ada masalah akses.
                java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) { // Kalau look and feel nggak didukung.
                java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
    
    
     // Ini adalah deklarasi variabel-variabel komponen GUI.
    // Dibuat otomatis sama GUI Builder NetBeans, jangan diubah manual.
    // Variables declaration - do not modify//GEN-BEGIN:variables

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton registBtn;
    private javax.swing.JComboBox<String> roleCombo;
    private javax.swing.JCheckBox showPw;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
