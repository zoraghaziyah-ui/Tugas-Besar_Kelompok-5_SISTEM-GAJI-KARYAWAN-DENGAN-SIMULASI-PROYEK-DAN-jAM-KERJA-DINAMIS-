import java.util.ArrayList;
import java.util.List;
public class Karyawan {
    private String nama;
    private List<Proyek> daftarProyek;
    private double gajiPerJam;
    public Karyawan(String nama, double gajiPerJam) {
        this.nama = nama;
        this.gajiPerJam = gajiPerJam;
        this.daftarProyek = new ArrayList<>();
    }
    public void tambahProyek(Proyek p) {
        daftarProyek.add(p);
    }
    public int hitungTotalJam() {
        int total = 0;
        for (Proyek p : daftarProyek) {
            total += p.getJamKerja();
        }
        return total;
    }
     public double hitungBonus() {
        int totalKesulitan = 0;
        int proyekSelesai = 0;
        int totalProyek = daftarProyek.size();
        int totalJam = hitungTotalJam();
        for (Proyek p : daftarProyek) {
            totalKesulitan += p.getTingkatKesulitan();
            if (p.isSelesai()) proyekSelesai++;
        }
        if (proyekSelesai < totalProyek) {
            return 0;
        }
        double rataKesulitan = (double) totalKesulitan / totalProyek;
        double bonus = 0.05 * totalJam * rataKesulitan; 
        return bonus * 10000;
    }
    public double hitungGajiKotor() {
        return hitungTotalJam() * gajiPerJam + hitungBonus();
    }
    public double hitungPajak(double gajiKotor) {
        if (gajiKotor < 5000000) {
            return 0.10 * gajiKotor;
        } else if (gajiKotor < 10000000) {
            return 0.15 * gajiKotor;
        } else {
            return 0.20 * gajiKotor;
        }
    }
    public double hitungGajiBersih() {
        double gajiKotor = hitungGajiKotor();
        double pajak = hitungPajak(gajiKotor);
        return gajiKotor - pajak;
    }
    public String getNama() {
        return nama;
    }
    public double getEfisiensi() {
        int selesai = 0;
        for (Proyek p : daftarProyek) {
            if (p.isSelesai()) selesai++;
        }
        return (double) selesai / hitungTotalJam();
    }
     public void tampilkanData() {
        System.out.println("Nama Karyawan  : " + nama);
        System.out.println("Total Jam      : " + hitungTotalJam());
        System.out.println("Bonus          : Rp" + hitungBonus());
        System.out.println("Gaji Kotor     : Rp" + hitungGajiKotor());
        System.out.println("Gaji Bersih    : Rp" + hitungGajiBersih());
        System.out.println("-------------------------------------------");
    }
}