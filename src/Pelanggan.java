import java.util.ArrayList;
import java.util.List;

public class Pelanggan implements TampilkanInfo, Bayar {
  private String nama;
  private String email;
  private String noTelepon;
  private String metodePembayaran;
  private List<Tiket> daftarTiket;

  public Pelanggan(String nama, String email, String noTelepon) {
    this.nama = nama;
    this.email = email;
    this.noTelepon = noTelepon;
    this.daftarTiket = new ArrayList<>();
    this.metodePembayaran = "Cash"; // default
  }

  public String getNama() {
    return nama;
  }

  public String getEmail() {
    return email;
  }

  public String getNoTelepon() {
    return noTelepon;
  }

  public String getMetodePembayaran() {
    return metodePembayaran;
  }

  public void setMetodePembayaran(String metodePembayaran) {
    this.metodePembayaran = metodePembayaran;
  }

  public List<Tiket> getDaftarTiket() {
    return daftarTiket;
  }

  public void tambahTiket(Tiket tiket) {
    daftarTiket.add(tiket);
  }

  public void hapusTiket(Tiket tiket) {
    daftarTiket.remove(tiket);
  }

  public double getTotalPembelian() {
    double total = 0;
    for (Tiket tiket : daftarTiket) {
      total += tiket.getHargaTiket();
    }
    return total;
  }

  @Override
  public void prosesPembayaran(double jumlah) {
    System.out.println("\n=== PROSES PEMBAYARAN ===");
    System.out.println("Pelanggan: " + nama);
    System.out.println("Metode Pembayaran: " + metodePembayaran);
    System.out.println("Jumlah: Rp " + String.format("%.2f", jumlah));

    switch (metodePembayaran.toLowerCase()) {
      case "cash":
        ConsoleUtil.printSuccess("Pembayaran tunai berhasil!");
        break;
      case "debit":
        ConsoleUtil.printSuccess("Pembayaran dengan kartu debit berhasil!");
        break;
      case "credit":
        ConsoleUtil.printSuccess("Pembayaran dengan kartu kredit berhasil!");
        break;
      case "e-wallet":
        ConsoleUtil.printSuccess("Pembayaran dengan e-wallet berhasil!");
        break;
      default:
        ConsoleUtil.printSuccess("Pembayaran berhasil!");
    }
    System.out.println("Terima kasih atas pembayaran Anda!");
  }

  @Override
  public void tampilkanMetodePembayaran() {
    ConsoleUtil.printSubHeader("METODE PEMBAYARAN TERSEDIA");
    System.out.println("┌" + "─".repeat(30) + "┐");
    System.out.println("│ 1. Cash (Tunai)              │");
    System.out.println("│ 2. Debit Card                │");
    System.out.println("│ 3. Credit Card               │");
    System.out.println("│ 4. E-Wallet (OVO/GoPay/DANA) │");
    System.out.println("└" + "─".repeat(30) + "┘");
    System.out.println("\nMetode saat ini: " + ConsoleUtil.ANSI_YELLOW + metodePembayaran + ConsoleUtil.ANSI_RESET);
  }

  @Override
  public void tampilkanInfo() {
    System.out.println("\n" + "=".repeat(45));
    System.out.println("            INFO PELANGGAN");
    System.out.println("=".repeat(45));
    System.out.printf("%-16s: %s%n", "Nama", nama);
    System.out.printf("%-16s: %s%n", "Email", email);
    System.out.printf("%-16s: %s%n", "No. Telepon", noTelepon);
    System.out.printf("%-16s: %s%n", "Metode Pembayaran", metodePembayaran);
    System.out.printf("%-16s: %d%n", "Jumlah Tiket", daftarTiket.size());
    System.out.printf("%-16s: Rp %,.2f%n", "Total Pembelian", getTotalPembelian());
    System.out.println("=".repeat(45));
}

  public void tampilkanRiwayatTiket() {
    System.out.println("\n" + "=".repeat(45));
    System.out.println("            RIWAYAT TIKET");
    System.out.println("=".repeat(45));
    if (daftarTiket.isEmpty()) {
        System.out.println("Belum ada tiket yang dibeli.");
    } else {
        for (int i = 0; i < daftarTiket.size(); i++) {
            Tiket tiket = daftarTiket.get(i);
            System.out.printf("%d. %-10s - %s%n", 
                (i + 1), 
                tiket.getKodeTiket(), 
                tiket.getFilm().getJudul());
        }
    }
    System.out.println("=".repeat(45));
}
}