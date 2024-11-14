import java.util.Scanner;
public class InventarisGudang06 {
    public static void main (String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah jenis barang : ");
        int jmlJenis = sc.nextInt();
        System.out.print("Masukkan jumlah lokasi penyimpanan : ");
        int jmlLokasi = sc.nextInt();
        sc.nextLine();

        int[][] stok = new int[jmlJenis][jmlLokasi];
        String[] kota = new String[jmlLokasi];

        for (int i = 0; i < kota.length; i++) {
            System.out.print("Kota untuk lokasi " + (i + 1) + " : ");
            kota[i] = sc.nextLine();
        }

        System.out.println("\nMengisi stok barang...");
        for (int i = 0; i < stok.length; i++) { 
            System.out.print("Jenis barang (0-" + (stok.length - 1) + ") : ");
            int jenisBarang = sc.nextInt();
            System.out.print("Lokasi (0-" + (jmlLokasi - 1) + ") : ");
            int letakBarang = sc.nextInt();
            System.out.print("Tambah stok: ");
            int jmlstok = sc.nextInt();
            sc.nextLine();
            stok[jenisBarang][letakBarang] += jmlstok;
        }

        System.out.println("\nTabel inventaris: ");
        System.out.print("\t");
        for (int i=0;i<kota.length;i++) {
            System.out.print(" " + kota[i]);
        }
        System.out.println();

        for (int i = 0; i < stok.length; i++) {
            System.out.print("Jenis " + i + " :   ");
            for (int j = 0; j < stok[i].length; j++) {
                System.out.print(stok[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nTotal stok untuk setiap jenis barang : ");
        for (int i = 0; i < stok.length; i++) {
            int totalstok = 0;
            for (int j = 0; j < stok[i].length; j++) {
                totalstok += stok[i][j];
            }
            System.out.println("Jenis barang ke-" + i + " : " + totalstok);
        }

        System.out.println("\nLokasi dengan stok terbanyak");
        for (int i = 0; i < stok.length; i++) {
            int max = 0;
            int lokasiTerbanyak = -1;
            for (int j = 0; j < stok[i].length; j++) {
                if (stok[i][j] > max) {
                    max = stok[i][j];
                    lokasiTerbanyak = j;
                }
            }
            if (lokasiTerbanyak != -1) {
                System.out.println("Jenis barang ke-" + (i + 1) + " : " + kota[lokasiTerbanyak]);
            } else {
                System.out.println("Jenis barang ke-" + (i + 1) + " : Tidak ada stok");
            }
        }
    }
}