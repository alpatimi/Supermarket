// File: Product.java
package model;

/**
 * Ini adalah kelas induk (superclass) abstrak kita, namanya `Product`.
 * Kenapa abstrak? Karena `Product` itu cuma konsep umum, nggak bisa langsung dibikin objeknya.
 * Kita harus bikin anak-anaknya dulu kayak `Makanan`, `Minuman`, atau `Kebutuhan` baru bisa dipakai.
 * Kelas ini mendefinisikan properti dan method dasar yang dimiliki SEMUA jenis produk.
 */
public abstract class Product { //
    // Ini properti (atau atribut) dari setiap produk. Dikasih 'protected' biar anak-anaknya bisa langsung akses.
    protected int id; // ID unik produk.
    protected String nama; // Nama produk.
    protected double harga; // Harga produk.
    protected int stock; // Jumlah stok produk yang tersedia.

    /**
     * Ini konstruktor PERTAMA.
     * Dipakai kalau kita mau bikin objek `Product` (via subclass-nya) dengan semua detail lengkap, termasuk ID.
     *
     * @param id Ini ID unik produk.
     * @param nama Ini nama produknya.
     * @param harga Ini harga jual produknya.
     * @param stock Ini jumlah stok produk.
     */
    public Product(int id, String nama, double harga, int stock) { //
        this.id = id; // Mengisi properti id dengan nilai dari parameter id.
        this.nama = nama; // Mengisi properti nama.
        this.harga = harga; // Mengisi properti harga.
        this.stock = stock; // Mengisi properti stock.
    }

    /**
     * Ini konstruktor KEDUA.
     * Dipakai kalau kita bikin objek `Product` dengan ID, nama, dan harga, tapi stoknya mau diset default 0.
     * Mungkin jarang dipakai, tapi ini contoh overloading konstruktor.
     *
     * @param id ID unik produk.
     * @param nama Nama produk.
     * @param harga Harga produk.
     */
    public Product(int id, String nama, double harga) { //
        this.id = id; //
        this.nama = nama; //
        this.harga = harga; //
        this.stock = 0; // Stoknya langsung diset 0.
    }

    /**
     * Ini konstruktor KETIGA.
     * Paling sering dipakai buat nambahin produk baru yang ID-nya nanti digenerate otomatis sama database.
     * Jadi, kita cuma perlu masukin nama, harga, sama stok awalnya.
     *
     * @param nama Nama produk.
     * @param harga Harga produk.
     * @param stock Stok produk.
     */
    public Product(String nama, double harga, int stock) { //
        this.nama = nama; //
        this.harga = harga; //
        this.stock = stock; //
    }

    /**
     * Ini adalah method abstrak.
     * Artinya, method ini cuma dideklarasiin aja di sini, nggak ada isinya.
     * Setiap anak dari `Product` (Kayak `Makanan`, `Minuman`, `Kebutuhan`) WAJIB mengisi (override) method ini.
     * Gunanya buat ngasih tau kategori spesifik dari produk tersebut.
     *
     * @return Mengembalikan String yang berisi kategori produk (misal "Makanan", "Minuman", dll.).
     */
    public abstract String getKategori(); //

    // Di bawah ini adalah method-method "Getter" dan "Setter".
    // Gunanya buat ngambil (get) atau ngubah (set) nilai dari properti-properti produk.
    // Ini penting buat enkapsulasi, biar akses ke data produk terkontrol.

    /**
     * Mengambil ID dari produk.
     * @return ID produk.
     */
    public int getId() { //
        return id; //
    }

    /**
     * Mengubah ID produk.
     * @param id ID produk yang baru.
     */
    public void setId(int id) { //
        this.id = id; //
    }

    /**
     * Mengambil nama produk.
     * @return Nama produk.
     */
    public String getNama() { //
        return nama; //
    }

    /**
     * Mengubah nama produk.
     * @param nama Nama produk yang baru.
     */
    public void setNama(String nama) { //
        this.nama = nama; //
    }

    /**
     * Mengambil harga produk.
     * @return Harga produk.
     */
    public double getHarga() { //
        return harga; //
    }

    /**
     * Mengubah harga produk.
     * @param harga Harga produk yang baru.
     */
    public void setHarga(double harga) { //
        this.harga = harga; //
    }

    /**
     * Mengambil jumlah stok produk.
     * @return Jumlah stok produk.
     */
    public int getStock() { //
        return stock; //
    }

    /**
     * Mengubah jumlah stok produk.
     * @param stock Jumlah stok produk yang baru.
     */
    public void setStock(int stock) { //
        this.stock = stock; //
    }
}