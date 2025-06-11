# Java Cinema - Sistem Tiket Bioskop

Sistem manajemen tiket bioskop yang dikembangkan menggunakan Java dengan konsep Object-Oriented Programming (OOP). Proyek ini mendemonstrasikan implementasi inheritance, polymorphism, interface, dan enkapsulasi dalam simulasi pembelian tiket bioskop.

## 📋 Deskripsi Proyek

Java Cinema adalah aplikasi console yang mensimulasikan sistem pembelian tiket bioskop dengan fitur:
- Manajemen film (Regular dan IMAX)
- Sistem reservasi kursi studio
- Pemrosesan pembayaran dengan berbagai metode
- Pencetakan tiket lengkap
- Riwayat pembelian pelanggan

## 🏗️ Struktur Folder

```
Java_Cinema/
├── src/                    # Source code Java
│   ├── App.java           # Main application
│   ├── Film.java          # Abstract class Film
│   ├── FilmRegular.java   # Implementasi Film Regular
│   ├── FilmIMAX.java      # Implementasi Film IMAX
│   ├── Studio.java        # Manajemen studio dan kursi
│   ├── Tiket.java         # Sistem tiket
│   ├── Pelanggan.java     # Manajemen pelanggan
│   ├── TampilkanInfo.java # Interface tampilan info
│   └── Bayar.java         # Interface pembayaran
├── bin/                   # Compiled output files
├── lib/                   # Dependencies (kosong)
├── ClassDiagram.puml      # Diagram kelas UML
└── README.md             # Dokumentasi proyek
```

## 🎯 Konsep OOP yang Diimplementasikan

### 1. **Inheritance (Pewarisan)**
- [`Film`](src/Film.java) sebagai abstract class
- [`FilmRegular`](src/FilmRegular.java) extends [`Film`](src/Film.java)
- [`FilmIMAX`](src/FilmIMAX.java) extends [`Film`](src/Film.java)

### 2. **Polymorphism**
- Method [`cetakTiket()`](src/Film.java) yang di-override di setiap subclass
- Method [`getJenisFilm()`](src/Film.java) dengan implementasi berbeda

### 3. **Interface**
- [`TampilkanInfo`](src/TampilkanInfo.java) - Menampilkan informasi objek
- [`Bayar`](src/Bayar.java) - Proses pembayaran

### 4. **Encapsulation**
- Private attributes dengan getter/setter methods
- Data hiding pada semua class

## 🚀 Cara Menjalankan

### Prerequisites
- Java Development Kit (JDK) 23 atau lebih tinggi
- Visual Studio Code dengan Java Extension Pack

### Langkah-langkah:

1. **Clone atau download proyek**
   ```bash
   git clone <repository-url>
   cd Java_Cinema
   ```

2. **Compile semua file Java**
   ```bash
   javac -d bin src/*.java
   ```

3. **Jalankan aplikasi**
   ```bash
   java -cp bin App
   ```

### Menggunakan VS Code:
1. Buka folder proyek di VS Code
2. Tekan `F5` atau klik "Run" pada [`App.java`](src/App.java)

## 💡 Fitur Utama

### 🎬 Manajemen Film
- **Film Regular**: Dengan opsi subtitle Indonesia
- **Film IMAX**: Dengan teknologi 3D dan kualitas audio Dolby Atmos

### 🏢 Sistem Studio
- Layout kursi dinamis dengan visualisasi
- Reservasi dan pembatalan kursi
- Validasi ketersediaan kursi

### 🎫 Sistem Tiket
- Kode tiket unik
- Informasi lengkap (film, studio, kursi, jadwal)
- Cetak tiket profesional

### 💳 Sistem Pembayaran
- Cash (Tunai)
- Kartu Debit
- Kartu Kredit  
- E-Wallet (OVO, GoPay, DANA)

### 👤 Manajemen Pelanggan
- Profil pelanggan lengkap
- Riwayat pembelian tiket
- Total transaksi

## 📊 Class Diagram

Lihat [`ClassDiagram.puml`](ClassDiagram.puml) untuk diagram kelas lengkap yang menunjukkan:
- Relasi inheritance dan interface
- Composition dan association
- Attributes dan methods setiap class

## 🔧 Konfigurasi VS Code

File [`.vscode/settings.json`](.vscode/settings.json) sudah dikonfigurasi untuk:
- Source path: `src/`
- Output path: `bin/`
- Library path: `lib/`

## 📝 Contoh Output

```
==========================================================
         SELAMAT DATANG DI Java CINEMA
==========================================================

=== TIKET FILM REGULAR ===
Judul: Pengabdi Setan 2
Genre: Horror
Durasi: 119 menit
Harga: Rp 35000.00
Subtitle Indonesia: Ya
Studio: Regular

==================================================
           Java CINEMA
==================================================
Kode Tiket    : TKT001
Film          : Pengabdi Setan 2
Jenis         : Film Regular
Studio        : Studio A (Regular)
Kursi         : C6
Jadwal        : 15/06/2025 19:30
Pelanggan     : Budi Santoso
Harga         : Rp 35000.00
==================================================
```
---

*Proyek ini dibuat untuk keperluan akademik dan pembelajaran konsep OOP dengan Java.*
