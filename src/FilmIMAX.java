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
        System.out.println("\n=== TIKET FILM IMAX ===");
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Harga: Rp " + String.format("%.2f", harga));
        System.out.println("Teknologi 3D: " + (teknologi3D ? "Ya" : "Tidak"));
        System.out.println("Kualitas Audio: " + kualitasAudio);
        System.out.println("Studio: IMAX");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Teknologi 3D: " + (teknologi3D ? "Ya" : "Tidak"));
        System.out.println("Kualitas Audio: " + kualitasAudio);
    }
}
