public class Studio implements TampilkanInfo {
  private String namaStudio;
  private String jenisStudio;
  private int kapasitas;
  private boolean[][] kursi; // true = terisi, false = kosong
  private int jumlahBaris;
  private int jumlahKolom;

  public Studio(String namaStudio, String jenisStudio, int jumlahBaris, int jumlahKolom) {
    this.namaStudio = namaStudio;
    this.jenisStudio = jenisStudio;
    this.jumlahBaris = jumlahBaris;
    this.jumlahKolom = jumlahKolom;
    this.kapasitas = jumlahBaris * jumlahKolom;
    this.kursi = new boolean[jumlahBaris][jumlahKolom];

    // Inisialisasi semua kursi kosong
    for (int i = 0; i < jumlahBaris; i++) {
      for (int j = 0; j < jumlahKolom; j++) {
        kursi[i][j] = false;
      }
    }
  }

  public String getNamaStudio() {
    return namaStudio;
  }

  public String getJenisStudio() {
    return jenisStudio;
  }

  public int getKapasitas() {
    return kapasitas;
  }

  public int getJumlahBaris() {
    return jumlahBaris;
  }

  public int getJumlahKolom() {
    return jumlahKolom;
  }

  public boolean isKursiTersedia(int baris, int kolom) {
    if (baris >= 0 && baris < jumlahBaris && kolom >= 0 && kolom < jumlahKolom) {
      return !kursi[baris][kolom];
    }
    return false;
  }

  // Example enhancement for seat validation
  public boolean reservasiKursi(int baris, int kolom) {
    try {
      if (isKursiTersedia(baris, kolom)) {
        kursi[baris][kolom] = true;
        return true;
      }
      return false;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Nomor kursi tidak valid!");
      return false;
    }
  }

  public void batalkanReservasi(int baris, int kolom) {
    if (baris >= 0 && baris < jumlahBaris && kolom >= 0 && kolom < jumlahKolom) {
      kursi[baris][kolom] = false;
    }
  }

  public void tampilkanLayoutKursi() {
    ConsoleUtil.printHeader("LAYOUT KURSI " + namaStudio.toUpperCase());
    
    // Header kolom dengan warna biru
    System.out.print(ConsoleUtil.ANSI_BLUE + "     ");
    for (int j = 0; j < jumlahKolom; j++) {
        System.out.printf("%2d  ", j + 1);
    }
    System.out.println("\n    " + "-".repeat(jumlahKolom * 4) + ConsoleUtil.ANSI_RESET);

    // Layout kursi dengan warna
    for (int i = 0; i < jumlahBaris; i++) {
        System.out.printf(ConsoleUtil.ANSI_BLUE + " %c │ " + ConsoleUtil.ANSI_RESET, 'A' + i);
        for (int j = 0; j < jumlahKolom; j++) {
            if (kursi[i][j]) {
                System.out.print(ConsoleUtil.ANSI_RED + " X  " + ConsoleUtil.ANSI_RESET);
            } else {
                System.out.print(ConsoleUtil.ANSI_GREEN + " O  " + ConsoleUtil.ANSI_RESET);
            }
        }
        System.out.println();
    }
    
    System.out.println("\nKeterangan:");
    System.out.println(ConsoleUtil.ANSI_GREEN + "O" + ConsoleUtil.ANSI_RESET + " = Tersedia");
    System.out.println(ConsoleUtil.ANSI_RED + "X" + ConsoleUtil.ANSI_RESET + " = Terisi");
    System.out.println("=".repeat(50));
}

@Override
public void tampilkanInfo() {
    System.out.println("\n" + "=".repeat(40));
    System.out.println("            INFO STUDIO");
    System.out.println("=".repeat(40));
    System.out.printf("%-14s: %s%n", "Nama Studio", namaStudio);
    System.out.printf("%-14s: %s%n", "Jenis Studio", jenisStudio);
    System.out.printf("%-14s: %d kursi%n", "Kapasitas", kapasitas);
    System.out.printf("%-14s: %d baris x %d kolom%n", "Ukuran", jumlahBaris, jumlahKolom);
    System.out.println("=".repeat(40));
}
}