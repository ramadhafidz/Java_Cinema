import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tiket implements TampilkanInfo {
    private String kodeTiket;
    private Film film;
    private Studio studio;
    private LocalDateTime jadwalTayang;
    private int baris;
    private int kolom;
    private double hargaTiket;
    private Pelanggan pelanggan;

    public Tiket(String kodeTiket, Film film, Studio studio, LocalDateTime jadwalTayang,
            int baris, int kolom, Pelanggan pelanggan) {
        this.kodeTiket = kodeTiket;
        this.film = film;
        this.studio = studio;
        this.jadwalTayang = jadwalTayang;
        this.baris = baris;
        this.kolom = kolom;
        this.pelanggan = pelanggan;
        this.hargaTiket = film.getHarga();
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public Film getFilm() {
        return film;
    }

    public Studio getStudio() {
        return studio;
    }

    public LocalDateTime getJadwalTayang() {
        return jadwalTayang;
    }

    public int getBaris() {
        return baris;
    }

    public int getKolom() {
        return kolom;
    }

    public double getHargaTiket() {
        return hargaTiket;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public String getNomorKursi() {
        return String.valueOf((char) ('A' + baris)) + (kolom + 1);
    }

    public void cetakTiketLengkap() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           ROYAN CINEMA");
        System.out.println("=".repeat(50));
        System.out.println("Kode Tiket    : " + kodeTiket);
        System.out.println("Film          : " + film.getJudul());
        System.out.println("Jenis         : " + film.getJenisFilm());
        System.out.println("Studio        : " + studio.getNamaStudio() + " (" + studio.getJenisStudio() + ")");
        System.out.println("Kursi         : " + getNomorKursi());
        System.out.println("Jadwal        : " + jadwalTayang.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Pelanggan     : " + pelanggan.getNama());
        System.out.println("Harga         : Rp " + String.format("%.2f", hargaTiket));
        System.out.println("=".repeat(50));
        System.out.println("Terima kasih telah memilih Royan Cinema!");
        System.out.println("=".repeat(50));
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("\n=== INFO TIKET ===");
        System.out.println("Kode Tiket: " + kodeTiket);
        System.out.println("Film: " + film.getJudul());
        System.out.println("Studio: " + studio.getNamaStudio());
        System.out.println("Kursi: " + getNomorKursi());
        System.out.println("Jadwal: " + jadwalTayang.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("Harga: Rp " + String.format("%.2f", hargaTiket));
    }
}
