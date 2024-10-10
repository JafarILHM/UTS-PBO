package ManajemenKaryawan;

public class Karyawan {
    String Nama;
    int IDKaryawan;
    int HariKerja;
    String Posisi;
    double Gaji;

    public Karyawan(String Nama, int IDKaryawan, int HariKerja, String Posisi, double Gaji) {
        this.Nama = Nama;
        this.IDKaryawan = IDKaryawan;
        this.HariKerja = HariKerja;
        this.Posisi = Posisi;
        this.Gaji = Gaji;
    }
    
    public String getNama() {
        return Nama;
    }
    
    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    
    public int getIDKaryawan() {
        return IDKaryawan;
    }
    
    public void setIDKaryawan(int IDKaryawan) {
        this.IDKaryawan = IDKaryawan;
    }
    
    public int getHariKerja() {
        return HariKerja;
    }
    
    public void setHariKerja(int HariKerja) {
        this.HariKerja = HariKerja;
    }
    
    public String getPosisi() {
        return Posisi;
    }
    
    public void setPosisi(String Posisi) {
        this.Posisi = Posisi;
    }
    
    public double getGaji() {
        return Gaji;
    }
    
    public void setGaji(double Gaji) {
        this.Gaji = Gaji;
    }
    
    public int HitungHariKerja(int TotalHariBulan) {
        int HariKerja = 0;
        for (int i = 1; i <= TotalHariBulan; i++) {
            HariKerja++; 
        }
        return HariKerja; 
    }
}
