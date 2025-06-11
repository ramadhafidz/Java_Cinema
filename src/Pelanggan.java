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
                System.out.println("Pembayaran tunai berhasil!");
                break;
            case "debit":
                System.out.println("Pembayaran dengan kartu debit berhasil!");
                break;
            case "credit":
                System.out.println("Pembayaran dengan kartu kredit berhasil!");
                break;
            case "e-wallet":
                System.out.println("Pembayaran dengan e-wallet berhasil!");
                break;
            default:
                System.out.println("Pembayaran berhasil!");
        }
        System.out.println("Terima kasih atas pembayaran Anda!");
    }

    @Override
    public void tampilkanMetodePembayaran() {
        System.out.println("\n=== METODE PEMBAYARAN TERSEDIA ===");
        System.out.println("1. Cash (Tunai)");
        System.out.println("2. Debit Card");
        System.out.println("3. Credit Card");
        System.out.println("4. E-Wallet (OVO, GoPay, DANA)");
        System.out.println("Metode saat ini: " + metodePembayaran);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("\n=== INFO PELANGGAN ===");
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("No. Telepon: " + noTelepon);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Jumlah Tiket: " + daftarTiket.size());
        System.out.println("Total Pembelian: Rp " + String.format("%.2f", getTotalPembelian()));
    }

    public void tampilkanRiwayatTiket() {
        System.out.println("\n=== RIWAYAT TIKET ===");
        if (daftarTiket.isEmpty()) {
            System.out.println("Belum ada tiket yang dibeli.");
        } else {
            for (int i = 0; i < daftarTiket.size(); i++) {
                System.out.println((i + 1) + ". " + daftarTiket.get(i).getKodeTiket() +
                        " - " + daftarTiket.get(i).getFilm().getJudul());
            }
        }
    }
}
