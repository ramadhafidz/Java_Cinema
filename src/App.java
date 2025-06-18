import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=".repeat(60));
    System.out.println("         SELAMAT DATANG DI ROYAN CINEMA");
    System.out.println("=".repeat(60));

    // Inisialisasi data
    List<Film> daftarFilm = new ArrayList<>();
    List<Studio> daftarStudio = new ArrayList<>();

    // Menambahkan film-film yang tersedia
    daftarFilm.add(new FilmRegular("Pengabdi Setan 2", "Horror", 119, 35000, "D 17+", true));
    daftarFilm.add(new FilmRegular("Mencuri Raden Saleh", "Action", 127, 40000, "R 13+", true));
    daftarFilm.add(new FilmIMAX("Avengers: Endgame", "Action", 181, 75000, "SU", true, "Dolby Atmos"));
    daftarFilm.add(new FilmIMAX("Avatar 2", "Sci-Fi", 192, 80000, "R 13+", true, "Dolby Atmos"));

    // Menambahkan studio-studio
    daftarStudio.add(new Studio("Studio A", "Regular", 8, 10));
    daftarStudio.add(new Studio("Studio B", "Regular", 8, 10));
    daftarStudio.add(new Studio("Studio IMAX", "IMAX", 6, 12));

    // Input data pelanggan
    System.out.println("\n=== INPUT DATA PELANGGAN ===");
    System.out.print("Masukkan nama: ");
    String nama = scanner.nextLine();
    System.out.print("Masukkan email: ");
    String email = scanner.nextLine();
    System.out.print("Masukkan no telepon: ");
    String noTelepon = scanner.nextLine();

    Pelanggan pelanggan = new Pelanggan(nama, email, noTelepon);

    boolean lanjut = true;
    while (lanjut) {
      ConsoleUtil.clearScreen();
      ConsoleUtil.printHeader("MENU UTAMA");
      System.out.println("┌" + "─".repeat(25) + "┐");
      System.out.println("│ 1. Lihat Daftar Film    │");
      System.out.println("│ 2. Beli Tiket           │");
      System.out.println("│ 3. Lihat Tiket Saya     │");
      System.out.println("│ 4. Keluar               │");
      System.out.println("└" + "─".repeat(25) + "┘");
      System.out.print("\nPilih menu (1-4): ");


      int menu = scanner.nextInt();
      scanner.nextLine(); // consume newline

      switch (menu) {
        case 1:
          ConsoleUtil.clearScreen();
          // Menampilkan daftar film
          System.out.println("\n=== DAFTAR FILM ===");
          for (int i = 0; i < daftarFilm.size(); i++) {
            System.out.println("\nFilm " + (i + 1));
            daftarFilm.get(i).tampilkanInfo();
          }
          ConsoleUtil.pressEnterToContinue();
          break;

        case 2:
          ConsoleUtil.clearScreen();
          // Proses pembelian tiket
          System.out.println("\n=== PEMBELIAN TIKET ===");

          // Pilih film
          System.out.println("\nDaftar Film:");
          for (int i = 0; i < daftarFilm.size(); i++) {
            System.out.println((i + 1) + ". " + daftarFilm.get(i).getJudul() +
              " (" + daftarFilm.get(i).getJenisFilm() + ")");
          }
          System.out.print("Pilih film (1-" + daftarFilm.size() + "): ");
          int pilihFilm = scanner.nextInt() - 1;
          Film filmPilihan = daftarFilm.get(pilihFilm);

          // Pilih studio yang sesuai dengan jenis film
          Studio studioPilihan = null;
          for (Studio studio : daftarStudio) {
            if (filmPilihan instanceof FilmIMAX && studio.getJenisStudio().equals("IMAX") ||
              filmPilihan instanceof FilmRegular && studio.getJenisStudio().equals("Regular")) {
              studioPilihan = studio;
              break;
            }
          }

          if (studioPilihan == null) {
            System.out.println("Error: No compatible studio found for the selected film.");
            return;
          }
          studioPilihan.tampilkanLayoutKursi();

          // Pilih kursi
          System.out.println("\nPilih Kursi:");
          System.out.print("Masukkan baris (A-" + (char)('A' + studioPilihan.getJumlahBaris() - 1) + "): ");
          scanner.nextLine(); // consume newline
          char barisPilihan = scanner.nextLine().toUpperCase().charAt(0);
          int baris = barisPilihan - 'A';

          System.out.print("Masukkan nomor kursi (1-" + studioPilihan.getJumlahKolom() + "): ");
          int kolom = scanner.nextInt() - 1;

          // Reservasi kursi
          if (studioPilihan.reservasiKursi(baris, kolom)) {
            // Generate kode tiket
            String kodeTiket = "TKT" + String.format("%03d", pelanggan.getDaftarTiket().size() + 1);

            // Set jadwal (untuk simulasi menggunakan jadwal tetap)
            LocalDateTime jadwal = LocalDateTime.now().plusDays(1).withHour(19).withMinute(30);

            // Buat tiket
            Tiket tiket = new Tiket(kodeTiket, filmPilihan, studioPilihan, jadwal, baris, kolom, pelanggan);

            // Pilih metode pembayaran
            pelanggan.tampilkanMetodePembayaran();
            System.out.print("Pilih metode pembayaran (1-4): ");
            int pilihBayar = scanner.nextInt();
            String metodeBayar = switch (pilihBayar) {
              case 2 -> "Debit";
              case 3 -> "Credit";
              case 4 -> "E-Wallet";
              default -> "Cash";
            };
            pelanggan.setMetodePembayaran(metodeBayar);

            // Proses pembayaran
            pelanggan.prosesPembayaran(tiket.getHargaTiket());

            // Tambahkan tiket ke daftar tiket pelanggan
            pelanggan.tambahTiket(tiket);

            // Cetak tiket
            tiket.cetakTiketLengkap();
          } else {
            System.out.println("Kursi tidak tersedia atau tidak valid!");
          }
          ConsoleUtil.pressEnterToContinue();
          break;

        case 3:
          // Menampilkan info pelanggan dan tiket
          ConsoleUtil.clearScreen();
          pelanggan.tampilkanInfo();
          pelanggan.tampilkanRiwayatTiket();
          ConsoleUtil.pressEnterToContinue();
          break;

        case 4:
          lanjut = false;
          break;

        default:
          System.out.println("Menu tidak valid!");
      }
    }

    scanner.close();

    System.out.println("\n" + "=".repeat(60));
    System.out.println("     TERIMA KASIH TELAH MENGGUNAKAN ROYAN CINEMA");
    System.out.println("=".repeat(60));
  }
}