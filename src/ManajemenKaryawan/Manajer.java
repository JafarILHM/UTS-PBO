package ManajemenKaryawan;

public class Manajer extends Karyawan {
    String Divisi;
    
    public Manajer(String Nama, int IDKaryawan, int HariKerja, String Posisi, double Gaji, String Divisi) {
        super(Nama, IDKaryawan, HariKerja, Posisi, Gaji);
        this.Divisi = Divisi;
    }
    
    public String getDivisi() {
        return Divisi;
    }
    
    public void setDivisi(String divisi) {
        this.Divisi = divisi;
    }

    public void MengelolaKaryawan() {
        System.out.println("Mengelola Karyawan di divisi " + Divisi); 
    }
    
    public void Bekerja() {
        System.out.println("Manajer bekerja di divisi " + Divisi); 
    }
}
