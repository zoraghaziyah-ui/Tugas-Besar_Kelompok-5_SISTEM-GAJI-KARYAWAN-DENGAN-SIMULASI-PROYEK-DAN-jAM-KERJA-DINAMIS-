import java.util.ArrayList;
import java.util.List;
public class Departemen {
    private List<Karyawan> tim;
    public Departemen() {
        tim = new ArrayList<>();
    }
    public void tambahKaryawan(Karyawan k) {
        tim.add(k);
    }
    public void tampilkanLaporanGaji() {
        System.out.println("\n=== LAPORAN GAJI KARYAWAN ===");
        for (Karyawan k : tim) {
            k.tampilkanData();
        }
    }
    public void cariKaryawanPalingEfisien() {
        Karyawan efisien = null;
        double maxEf = 0;
        for (Karyawan k : tim) {
            if (k.getEfisiensi() > maxEf) {
                maxEf = k.getEfisiensi();
                efisien = k;
            }
        }
        if (efisien != null) {
            System.out.println("Karyawan paling efisien: " + efisien.getNama() +
                               " (Efisiensi: " + String.format("%.4f", maxEf) + ")");
        }
    }
}