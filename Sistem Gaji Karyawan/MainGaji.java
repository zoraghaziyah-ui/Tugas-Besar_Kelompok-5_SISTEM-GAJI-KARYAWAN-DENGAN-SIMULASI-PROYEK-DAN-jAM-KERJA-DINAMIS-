import java.util.Scanner;
public class MainGaji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Departemen departemen = new Departemen();
        System.out.print("Masukkan jumlah karyawan: ");
        int jmlKaryawan = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < jmlKaryawan; i++) {
            System.out.println("\n=== Input Data Karyawan ke-" + (i + 1) + " ===");
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("Gaji per jam (Rp): ");
            double gajiPerJam = sc.nextDouble();
            sc.nextLine();
            Karyawan k = new Karyawan(nama, gajiPerJam);
            System.out.print("Masukkan jumlah proyek: ");
            int jmlProyek = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < jmlProyek; j++) {
                System.out.println("\nProyek ke-" + (j + 1));
                System.out.print("Nama proyek: ");
                String namaProyek = sc.nextLine();
                System.out.print("Tingkat kesulitan (1–5): ");
                int tingkat = sc.nextInt();
                System.out.print("Jam kerja proyek: ");
                int jam = sc.nextInt();
                System.out.print("Apakah proyek selesai? (true/false): ");
                boolean selesai = sc.nextBoolean();
                sc.nextLine();
                k.tambahProyek(new Proyek(namaProyek, tingkat, jam, selesai));
            }
            departemen.tambahKaryawan(k);
        }
        departemen.tampilkanLaporanGaji();
        departemen.cariKaryawanPalingEfisien();
        sc.close();
    }
}