package ilmu;

import java.util.ArrayList;
import java.util.Scanner;

class Tiket {
    private String namaPembeli;
    private String jenisTiket;
    private int jumlahTiket;

    // Constructor
    public Tiket(String namaPembeli, String jenisTiket, int jumlahTiket) {
        this.namaPembeli = namaPembeli;
        this.jenisTiket = jenisTiket;
        this.jumlahTiket = jumlahTiket;
    }

    // Getter and Setter for namaPembeli
    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    // Getter and Setter for jenisTiket
    public String getJenisTiket() {
        return jenisTiket;
    }

    public void setJenisTiket(String jenisTiket) {
        this.jenisTiket = jenisTiket;
    }

    // Getter and Setter for jumlahTiket
    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    @Override
    public String toString() {
        return "Nama Pembeli: " + namaPembeli + ", Jenis Tiket: " + jenisTiket + ", Jumlah Tiket: " + jumlahTiket;
    }
}

public class Posttest {
    private static ArrayList<Tiket> daftarTiket = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\nPilih operasi yang ingin Anda lakukan:");
            System.out.println("1. Tambah Tiket");
            System.out.println("2. Lihat Daftar Tiket");
            System.out.println("3. Update Tiket");
            System.out.println("4. Hapus Tiket");
            System.out.println("5. Keluar");

            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline di buffer

            switch (pilihan) {
                case 1:
                    tambahTiket();
                    break;
                case 2:
                    lihatDaftarTiket();
                    break;
                case 3:
                    updateTiket();
                    break;
                case 4:
                    hapusTiket();
                    break;
                case 5:
                    berjalan = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    private static void tambahTiket() {
        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();

        System.out.print("Masukkan jenis tiket: ");
        String jenisTiket = scanner.nextLine();

        System.out.print("Masukkan jumlah tiket: ");
        int jumlahTiket = scanner.nextInt();

        Tiket tiketBaru = new Tiket(namaPembeli, jenisTiket, jumlahTiket);
        daftarTiket.add(tiketBaru);

        System.out.println("Tiket berhasil ditambahkan!");
    }

    private static void lihatDaftarTiket() {
        if (daftarTiket.isEmpty()) {
            System.out.println("Daftar tiket kosong.");
        } else {
            System.out.println("\nDaftar Tiket:");
            for (Tiket tiket : daftarTiket) {
                System.out.println(tiket);
            }
        }
    }

    private static void updateTiket() {
        lihatDaftarTiket();
        System.out.print("Masukkan nomor tiket yang ingin diupdate: ");
        int nomorTiket = scanner.nextInt();

        if (nomorTiket >= 1 && nomorTiket <= daftarTiket.size()) {
            Tiket tiketTerpilih = daftarTiket.get(nomorTiket - 1);

            System.out.print("Masukkan nama pembeli baru: ");
            String namaPembeli = scanner.next();
            tiketTerpilih.setNamaPembeli(namaPembeli);

            System.out.print("Masukkan jenis tiket baru: ");
            String jenisTiket = scanner.next();
            tiketTerpilih.setJenisTiket(jenisTiket);

            System.out.print("Masukkan jumlah tiket baru: ");
            int jumlahTiket = scanner.nextInt();
            tiketTerpilih.setJumlahTiket(jumlahTiket);

            System.out.println("Tiket berhasil diupdate!");
        } else {
            System.out.println("Nomor tiket tidak valid.");
        }
    }

    private static void hapusTiket() {
        lihatDaftarTiket();
        System.out.print("Masukkan nomor tiket yang ingin dihapus: ");
        int nomorTiket = scanner.nextInt();

        if (nomorTiket >= 1 && nomorTiket <= daftarTiket.size()) {
            daftarTiket.remove(nomorTiket - 1);
            System.out.println("Tiket berhasil dihapus!");
        } else {
            System.out.println("Nomor tiket tidak valid.");
        }
    }
}
