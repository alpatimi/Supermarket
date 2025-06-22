package model;

public class Minuman extends Product {
    public Minuman(int id, String nama, double harga, int stock) {
    super(id, nama, harga, stock);
}
    public Minuman(String nama, double harga, int stock) {
    super(nama, harga, stock);
}


    @Override
    public String getKategori() {
        return "Minuman";
    }
}