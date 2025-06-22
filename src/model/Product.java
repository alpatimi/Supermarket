package model;

//superclass

public abstract class Product {
    protected int id;
    protected String nama;
    protected double harga;
    protected int stock;

    public Product(int id, String nama, double harga, int stock) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stock = stock;
    }
    
    public Product(int id, String nama, double harga) {
    this.id = id;
    this.nama = nama;
    this.harga = harga;
    this.stock = 0; 
}
    public Product(String nama, double harga, int stock) {
    this.nama = nama;
    this.harga = harga;
    this.stock = stock;
}


    public abstract String getKategori();

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
