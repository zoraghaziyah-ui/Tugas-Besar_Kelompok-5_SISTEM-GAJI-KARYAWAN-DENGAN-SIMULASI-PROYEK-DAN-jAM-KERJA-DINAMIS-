public class Proyek {
    private String nama;
    private int tingkatKesulitan;
    private int jamKerja;
    private boolean selesai;
    public Proyek(String nama, int tingkatKesulitan, int jamKerja, boolean selesai) {
        this.nama = nama;
        this.tingkatKesulitan = tingkatKesulitan;
        this.jamKerja = jamKerja;
        this.selesai = selesai;
    }
    public String getNama() {
        return nama;
    }
    public int getTingkatKesulitan() {
        return tingkatKesulitan;
    }
    public int getJamKerja() {
        return jamKerja;
    }
    public boolean isSelesai() {
        return selesai;
    }
}