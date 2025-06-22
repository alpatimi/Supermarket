package model;

// Subclass: Kebutuhan.java
public class Kebutuhan extends Product {
    public Kebutuhan(int id, String nama, double harga, int stock) {
    super(id, nama, harga, stock);
}
    
    
    public Kebutuhan(String nama, double harga, int stock) {
    super(nama, harga, stock);
}


    @Override
    public String getKategori() {
        return "Kebutuhan";
    }
}
