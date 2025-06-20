public abstract class Film implements TampilkanInfo {
  protected String judul;
  protected String genre;
  protected int durasi; // dalam menit
  protected double harga;
  protected String rating;

  public Film(String judul, String genre, int durasi, double harga, String rating) {
    this.judul = judul;
    this.genre = genre;
    this.durasi = durasi;
    this.harga = harga;
    this.rating = rating;
  }

  // Getter methods
  public String getJudul() {
    return judul;
  }

  public String getGenre() {
    return genre;
  }

  public int getDurasi() {
    return durasi;
  }

  public double getHarga() {
    return harga;
  }

  public String getRating() {
    return rating;
  }

  // Setter methods
  public void setJudul(String judul) {
    this.judul = judul;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setDurasi(int durasi) {
    this.durasi = durasi;
  }

  public void setHarga(double harga) {
    this.harga = harga;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  // Abstract method untuk polymorphism
  public abstract String getJenisFilm();

  public abstract void cetakTiket();

  @Override
  public void tampilkanInfo() {
    System.out.println("\n" + "=".repeat(40));
    System.out.println("              INFO FILM");
    System.out.println("=".repeat(40));
    System.out.printf("%-14s: %s%n", "Judul", judul);
    System.out.printf("%-14s: %s%n", "Genre", genre);
    System.out.printf("%-14s: %d menit%n", "Durasi", durasi);
    System.out.printf("%-14s: Rp %,.2f%n", "Harga", harga);
    System.out.printf("%-14s: %s%n", "Rating", rating);
    System.out.printf("%-14s: %s%n", "Jenis", getJenisFilm());
  }
}