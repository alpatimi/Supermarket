package model;

public class CartItem {
    private Product product;
    // Hapus properti duplikat ini jika Anda akan mengambilnya dari 'product'
    // private String nama;
    // private int productId;
    // private String kategori;
    // private double harga;
    // private int stock; // Ini juga harusnya tidak ada jika ini adalah stock item yang dibeli, bukan stock produk


    private int quantity; // Ini adalah kuantitas produk yang ditambahkan ke keranjang

    public CartItem(Product product, int quantity) {
        this.product = product; // Inisialisasi objek Product
        // Ambil data dari objek product yang dilewatkan
        // this.productId = product.getId(); // Jika Anda masih ingin menyimpan terpisah
        // this.nama = product.getNama();
        // this.kategori = product.getKategori();
        // this.harga = product.getHarga(); // Ini adalah harga satuan produk

        this.quantity = quantity; // Inisialisasi kuantitas yang dibeli
        // this.stock = product.getStok(); // Ini adalah stok asli produk, bukan quantity yang dibeli

        // Perhatikan: Anda tidak perlu menyimpan semua detail produk secara terpisah di CartItem
        // jika Anda sudah menyimpan objek Product itu sendiri.
        // Cukup akses detailnya melalui getProduct().getNama(), getProduct().getHarga(), dll.
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getHarga() * quantity;
    }

    // Ubah getter ini agar mengambil dari objek 'product'
    public int getProductId() {
        return product.getId();
    }
    public String getNama() {
        return product.getNama();
    }
    public String getKategori() {
        return product.getKategori();
    }
    public double getHarga() {
        return product.getHarga();
    }

    public double getTotalHarga() { // Ini menghitung total harga untuk item ini di keranjang
        return product.getHarga() * quantity;
    }

    // Hati-hati dengan method getStock() di CartItem.
    // Jika kolom di tabel keranjang Anda adalah 'Qty' (kuantitas yang dibeli),
    // maka method ini harusnya adalah getQuantity().
    // Jika Anda punya kolom 'Stock' di tabel keranjang yang berarti stok sisa produk,
    // itu tidak biasa ada di tabel keranjang, melainkan di tabel produk.
    // Asumsi 'Stock' di tabel keranjang itu sebenarnya 'Qty' (quantity yang dibeli):
    public int getStock(){ // Ganti nama method ini di CartItem menjadi getQuantity() jika memang itu maksudnya.
        return quantity; // Mengembalikan kuantitas yang dibeli, bukan stok produk
    }

    // Jika Anda ingin mengubah quantity setelah CartItem dibuat
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        // Tidak perlu menghitung ulang totalHargaItem jika tidak ada properti tersebut
    }
}