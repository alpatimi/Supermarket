package model;

// Simpan file ini sebagai RoleApp.java

/**
 * /**
 * Ini adalah interface utama kita, `RoleActionFace`.
 * Isinya adalah "cetakan" atau kontrak untuk setiap role (peran) di aplikasi kita.
 * Kenapa pake interface? Biar semua role punya perilaku dasar yang sama, tapi implementasinya bisa beda-beda.
 * Kerennya, di sini kita bisa punya abstract method, default method, sama static method!
 * @author timi
 */

interface RoleActionFace {
    /**
     * Ini method abstrak, namanya `showDashboard()`.
     * Artinya, method ini cuma deklarasi doang, nggak ada isinya.
     * Setiap kelas yang ngimplementasiin `RoleActionFace` WAJIB override (isi) method ini.
     * Jadi, setiap role nanti punya tampilan dashboard-nya sendiri-sendiri.
     */
    void showDashboard(); // abstract method
   
     /**
     * Nah, kalau ini `logout()` method default.
     * Enaknya method default itu, kita bisa kasih implementasi (isi) langsung di interface-nya.
     * Jadi, semua kelas yang ngimplementasiin interface ini udah langsung punya method `logout()` ini,
     * nggak perlu nulis ulang kodenya. Tapi kalau mau di-override juga bisa kok!
     */
    default void logout() {
        System.out.println("Logout berhasil.");
        /**
         * method yang isinya sudah ada di interface dan kelas2 lain hanya ti
         * tinggal memanggil method tersebut
         */
    }
       /**
     * Ini method static, namanya `welcomeMessage()`.
     * Method static ini beda lagi, kita bisa panggil langsung dari interface-nya,
     * nggak perlu bikin objek dari kelas yang ngimplementasiin interface ini.
     * Cocok buat fungsi-fungsi umum yang nggak butuh objek tertentu, kayak pesan selamat datang ini.
     */
    static void welcomeMessage() {
        /**
         * method yang bisa langsung dipanggil di interface itu sendiri
         * tanpa perlu membuat objek dari kelas yang mengimplemetasikan interface
         * 
         */
        System.out.println("Selamat datang di aplikasi Supermarket!");
    }
}

// ======= Admin class =======
/**
 * Ini adalah kelas `Admin`.
 * Dia ngimplementasiin interface `RoleActionFace`,
 * artinya dia HARUS punya method `showDashboard()` yang udah didefinisiin di interface.
 * Ini salah satu contoh penerapan OOP, yaitu polimorfisme, di mana objek `Admin` bisa diperlakukan sebagai `RoleActionFace`.
 */
class Admin implements RoleActionFace {
    /**
     * Ini implementasi method `showDashboard()` khusus buat `Admin`.
     * Kalau yang login admin, nanti dashboard admin yang kebuka.
     */
    @Override
    public void showDashboard() {
        System.out.println("Dashboard Admin terbuka.");
        /**
         * kelas admin adalah kelas yang mengimplementasi interface
         * kelas admin berarti harus ada 
         */
    }
}

// ======= Customer class =======
/**
 * Mirip sama `Admin`, ini adalah kelas `Customer`.
 * Dia juga ngimplementasiin `RoleActionFace`.
 * Jadi, dia juga wajib punya method `showDashboard()` sendiri.
 */
class Customer implements RoleActionFace {
     /**
     * Ini implementasi method `showDashboard()` khusus buat `Customer`.
     * Jadi, kalau yang login customer, dashboard customer yang muncul.
     */
    @Override
    public void showDashboard() {
        System.out.println("Dashboard Customer terbuka.");
    }
}

// ======= RoleAction class =======
 /* Kelas `RoleAction` ini semacam "pengatur" atau "pelayan" buat nanganin aksi-aksi berdasarkan role.
 * Di sini kita nunjukkin gimana kita bisa nanganin berbagai jenis role pake satu method doang,
 * yaitu `aksesDashboard()`, karena semua role itu adalah `RoleActionFace`. Keren kan OOP!
 */
class RoleAction {
    /**
     * Method `aksesDashboard()` ini yang paling penting.
     * Dia nerima parameter bertipe `RoleActionFace`,
     * jadi bisa nerima objek `Admin` atau `Customer` atau role lain di masa depan.
     * Kita cek dulu tipe objeknya (pake `instanceof`),
     * terus baru deh panggil `showDashboard()` yang sesuai dengan role-nya.
     * Ini contoh polymorphism in action!
     * @param role Objek role (bisa `Admin` atau `Customer`) yang mau diakses dashboard-nya.
     */
    public void aksesDashboard(RoleActionFace role) {
        if (role instanceof Admin) {
            System.out.println("Akses diberikan untuk Admin.");
            role.showDashboard();
        } else if (role instanceof Customer) {
            System.out.println("Akses diberikan untuk Customer.");
            role.showDashboard();
        } else {
            System.out.println("Role tidak dikenali.");
        }

        // Method logout ini langsung bisa dipanggil karena itu method default dari interface RoleActionFace.
        role.logout(); // memanggil method default
    }
}

// ======= Main class =======
 /* Ini adalah kelas `RoleApp`, yang ada method `main`-nya.
 * Ini adalah kelas tempat aplikasi kita mulai berjalan.
 * Di sini kita coba-coba gimana cara kerja interface, kelas, sama objek-objek kita.
 */
 class RoleApp {
     /**
     * Method `main` ini adalah gerbang utama aplikasi.
     * Semua kode bakal dieksekusi dari sini.
     * @param args Argumen baris perintah (kalau ada, tapi di sini nggak dipake).
     */
    public static void main(String[] args) {
        // Panggil method static dari interface langsung! Nggak perlu objek.
        RoleActionFace.welcomeMessage(); // static method
        // Bikin objek dari kelas RoleAction buat nanganin akses dashboard.
        RoleAction roleAction = new RoleAction();
         // Bikin objek admin dan customer, tapi tipenya RoleActionFace.
        // Ini nunjukkin polymorphism, objek Admin dan Customer bisa diperlakukan sebagai RoleActionFace.
        RoleActionFace admin = new Admin();
        RoleActionFace customer = new Customer();
         // Panggil method aksesDashboard() dengan objek admin.
        System.out.println("--- Login sebagai Admin ---");
        roleAction.aksesDashboard(admin);
         // Panggil method aksesDashboard() dengan objek cpstumer/.
        System.out.println("\n--- Login sebagai Customer ---");
        roleAction.aksesDashboard(customer);
    }
}


