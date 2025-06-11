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
        System.out.println("=== INFO FILM ===");
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Harga: Rp " + String.format("%.2f", harga));
        System.out.println("Rating: " + rating);
        System.out.println("Jenis: " + getJenisFilm());
    }
}
