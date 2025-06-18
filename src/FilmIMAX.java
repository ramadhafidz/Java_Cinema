public class FilmIMAX extends Film {
  private boolean teknologi3D;
  private String kualitasAudio;

  public FilmIMAX(String judul, String genre, int durasi, double harga, String rating, boolean teknologi3D,
      String kualitasAudio) {
    super(judul, genre, durasi, harga, rating);
    this.teknologi3D = teknologi3D;
    this.kualitasAudio = kualitasAudio;
  }

  public boolean isTeknologi3D() {
    return teknologi3D;
  }

  public void setTeknologi3D(boolean teknologi3D) {
    this.teknologi3D = teknologi3D;
  }

  public String getKualitasAudio() {
    return kualitasAudio;
  }

  public void setKualitasAudio(String kualitasAudio) {
    this.kualitasAudio = kualitasAudio;
  }

  @Override
  public String getJenisFilm() {
    return "Film IMAX";
  }

  @Override
  public void cetakTiket() {
    System.out.println("\n" + "=".repeat(40));
    System.out.println("            TIKET FILM IMAX");
    System.out.println("=".repeat(40));
    System.out.printf("%-14s: %s%n", "Judul", judul);
    System.out.printf("%-14s: %s%n", "Genre", genre);
    System.out.printf("%-14s: %d menit%n", "Durasi", durasi);
    System.out.printf("%-14s: Rp %,.2f%n", "Harga", harga);
    System.out.printf("%-14s: %s%n", "Teknologi 3D", teknologi3D ? "Ya" : "Tidak");
    System.out.printf("%-14s: %s%n", "Audio", kualitasAudio);
    System.out.printf("%-14s: IMAX%n", "Studio");
    System.out.println("=".repeat(40));
}

@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.printf("%-14s: %s%n", "Teknologi 3D", teknologi3D ? "Ya" : "Tidak");
    System.out.printf("%-14s: %s%n", "Audio", kualitasAudio);
    System.out.println("=".repeat(40));
}
}