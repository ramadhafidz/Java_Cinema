public class FilmRegular extends Film {
    private boolean subtitleIndonesia;

    public FilmRegular(String judul, String genre, int durasi, double harga, String rating, boolean subtitleIndonesia) {
        super(judul, genre, durasi, harga, rating);
        this.subtitleIndonesia = subtitleIndonesia;
    }

    public boolean isSubtitleIndonesia() {
        return subtitleIndonesia;
    }

    public void setSubtitleIndonesia(boolean subtitleIndonesia) {
        this.subtitleIndonesia = subtitleIndonesia;
    }

    @Override
    public String getJenisFilm() {
        return "Film Regular";
    }

    @Override
    public void cetakTiket() {
        System.out.println("\n=== TIKET FILM REGULAR ===");
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Harga: Rp " + String.format("%.2f", harga));
        System.out.println("Subtitle Indonesia: " + (subtitleIndonesia ? "Ya" : "Tidak"));
        System.out.println("Studio: Regular");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Subtitle Indonesia: " + (subtitleIndonesia ? "Ya" : "Tidak"));
    }
}
