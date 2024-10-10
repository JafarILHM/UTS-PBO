package ManajemenKaryawan;

public class Main {
    public static void main(String[] args) {
        Karyawan karyawan1 = new Karyawan("Ilham", 101, 22, "Staff", 5000000);
        System.out.println("Nama: " + karyawan1.getNama());
        System.out.println("ID Karyawan: " + karyawan1.getIDKaryawan());
        System.out.println("Hari Kerja: " + karyawan1.getHariKerja());
        System.out.println("Posisi: " + karyawan1.getPosisi());
        System.out.println("Gaji: " + karyawan1.getGaji());
        
        Manajer manajer1 = new Manajer("Jafaruddin", 102, 20, "Manajer", 8000000, "IT");
        System.out.println("\nNama: " + manajer1.getNama());
        System.out.println("ID Karyawan: " + manajer1.getIDKaryawan());
        System.out.println("Hari Kerja: " + manajer1.getHariKerja());
        System.out.println("Posisi: " + manajer1.getPosisi());
        System.out.println("Gaji: " + manajer1.getGaji());
        System.out.println("Divisi: " + manajer1.getDivisi());
        
        manajer1.MengelolaKaryawan();
        manajer1.Bekerja();
    }
}
