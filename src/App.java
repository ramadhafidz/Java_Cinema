import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demonstrasi Sistem Tiket Bioskop
        System.out.println("=".repeat(60));
        System.out.println("         SELAMAT DATANG DI ROYAN CINEMA");
        System.out.println("=".repeat(60));

        // 1. Membuat film-film yang tersedia (Inheritance & Polymorphism)
        FilmRegular filmRegular = new FilmRegular(
                "Pengabdi Setan 2", "Horror", 119, 35000, "D 17+", true);

        FilmIMAX filmIMAX = new FilmIMAX(
                "Avengers: Endgame", "Action", 181, 75000, "SU", true, "Dolby Atmos");

        // 2. Membuat studio
        Studio studioRegular = new Studio("Studio A", "Regular", 8, 10);
        Studio studioIMAX = new Studio("Studio IMAX", "IMAX", 6, 12);

        // 3. Membuat pelanggan
        Pelanggan pelanggan = new Pelanggan(
                "Budi Santoso", "budi@email.com", "081234567890");

        // Demonstrasi Interface TampilkanInfo
        System.out.println("\n" + "=".repeat(40));
        System.out.println("    DEMONSTRASI POLYMORPHISM & INTERFACE");
        System.out.println("=".repeat(40));

        // Polymorphism - Film Regular
        filmRegular.tampilkanInfo();
        filmRegular.cetakTiket();

        System.out.println();

        // Polymorphism - Film IMAX
        filmIMAX.tampilkanInfo();
        filmIMAX.cetakTiket();

        // Menampilkan info studio
        studioRegular.tampilkanInfo();
        studioIMAX.tampilkanInfo();

        // Menampilkan layout kursi
        studioRegular.tampilkanLayoutKursi();

        // Simulasi pembelian tiket
        System.out.println("\n" + "=".repeat(40));
        System.out.println("        SIMULASI PEMBELIAN TIKET");
        System.out.println("=".repeat(40));

        // Pilih kursi dan reservasi
        int baris = 2; // Baris C
        int kolom = 5; // Kolom 6

        if (studioRegular.reservasiKursi(baris, kolom)) {
            System.out.println("Kursi " + (char) ('A' + baris) + (kolom + 1) + " berhasil direservasi!");

            // Membuat tiket
            String kodeTiket = "TKT001";
            LocalDateTime jadwal = LocalDateTime.of(2025, 6, 15, 19, 30);

            Tiket tiket = new Tiket(kodeTiket, filmRegular, studioRegular,
                    jadwal, baris, kolom, pelanggan);

            // Menambahkan tiket ke pelanggan
            pelanggan.tambahTiket(tiket);

            // Menampilkan info tiket
            tiket.tampilkanInfo();

            // Interface Bayar - demonstrasi metode pembayaran
            pelanggan.tampilkanMetodePembayaran();
            pelanggan.setMetodePembayaran("Credit");
            pelanggan.prosesPembayaran(tiket.getHargaTiket());

            // Cetak tiket lengkap
            tiket.cetakTiketLengkap();

            // Menampilkan layout kursi setelah reservasi
            System.out.println("\nLayout kursi setelah reservasi:");
            studioRegular.tampilkanLayoutKursi();

        } else {
            System.out.println("Kursi tidak tersedia!");
        }

        // Demonstrasi pembelian tiket IMAX
        System.out.println("\n" + "=".repeat(40));
        System.out.println("     SIMULASI PEMBELIAN TIKET IMAX");
        System.out.println("=".repeat(40));

        int barisIMAX = 3; // Baris D
        int kolomIMAX = 6; // Kolom 7

        if (studioIMAX.reservasiKursi(barisIMAX, kolomIMAX)) {
            String kodeTiketIMAX = "TKT002";
            LocalDateTime jadwalIMAX = LocalDateTime.of(2025, 6, 16, 21, 0);

            Tiket tiketIMAX = new Tiket(kodeTiketIMAX, filmIMAX, studioIMAX,
                    jadwalIMAX, barisIMAX, kolomIMAX, pelanggan);

            pelanggan.tambahTiket(tiketIMAX);

            // Pembayaran dengan e-wallet
            pelanggan.setMetodePembayaran("E-Wallet");
            pelanggan.prosesPembayaran(tiketIMAX.getHargaTiket());

            tiketIMAX.cetakTiketLengkap();
        }

        // Menampilkan info pelanggan lengkap
        System.out.println("\n" + "=".repeat(40));
        System.out.println("         INFO PELANGGAN LENGKAP");
        System.out.println("=".repeat(40));

        pelanggan.tampilkanInfo();
        pelanggan.tampilkanRiwayatTiket();

        scanner.close();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("     TERIMA KASIH TELAH MENGGUNAKAN ROYAN CINEMA");
        System.out.println("=".repeat(60));
    }
}
