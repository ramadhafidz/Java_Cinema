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
        System.out.println("\n=== LAYOUT KURSI STUDIO " + namaStudio + " ===");
        System.out.print("   ");
        for (int j = 0; j < jumlahKolom; j++) {
            System.out.printf("%2d ", j + 1);
        }
        System.out.println();

        for (int i = 0; i < jumlahBaris; i++) {
            System.out.printf("%c  ", 'A' + i);
            for (int j = 0; j < jumlahKolom; j++) {
                System.out.print(kursi[i][j] ? " X " : " O ");
            }
            System.out.println();
        }
        System.out.println("Keterangan: O = Tersedia, X = Terisi");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("\n=== INFO STUDIO ===");
        System.out.println("Nama Studio: " + namaStudio);
        System.out.println("Jenis Studio: " + jenisStudio);
        System.out.println("Kapasitas: " + kapasitas + " kursi");
        System.out.println("Ukuran: " + jumlahBaris + " baris x " + jumlahKolom + " kolom");
    }
}
