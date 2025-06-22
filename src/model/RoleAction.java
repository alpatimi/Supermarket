package model;

public interface RoleAction {
    void showDashboard(); // abstract

    default void logout() {
        System.out.println("Logout berhasil.");
    }

    static void welcomeMessage() {
        System.out.println("Selamat datang di aplikasi Supermarket!");
    }
}


