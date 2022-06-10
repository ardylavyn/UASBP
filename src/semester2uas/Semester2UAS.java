
package FinalProjectUAS;
import java.util.Scanner;
public class appToko {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cBarang brg1 = new cBarang("Tas", 100000);
        cBarang brg2 = new cBarang("Sandal", 150000);
        cBarang brg3 = new cBarang("Sepatu", 200000);        
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih=0, pilih2=0,pilih3=0;
        int kode=100,jumlah;
        do{
            System.out.println("\nAplikasi Toko Maju Sejahtera");
            System.out.println("1.Pembeli");
            System.out.println("2.Anggota");
            System.out.println("3.Admin");
            System.out.println("4.Pemilik");  
            System.out.println("5.Exit");  
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
            switch(pilih){
                case 1:
                    //pembeli
                    kode++;
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama= ");
                    String nama = sc.next();
                    do{
                        System.out.println("Akun Pembeli");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Kembali");
                        System.out.print("Pilih = ");
                        pilih2 = sc.nextInt();
                        switch(pilih2){
                            case 1 :
                                cTransaksi br = null;
                                System.out.println("Daftar Barang");
                                System.out.println("1.Tas");
                                System.out.println("2.Sandal");
                                System.out.println("3.Sepatu");   
                                System.out.print("Pilih = ");
                                pilih3 = sc.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah =  sc.nextInt();
                                if (pilih3==1) {
                                    br = new cTransaksi(String.valueOf(kode), nama,brg1,  jumlah, 0);
                                }
                                else if (pilih3==2) {
                                    br = new cTransaksi(String.valueOf(kode), nama,brg2,  jumlah, 0);
                                }
                                else if (pilih3==3) {
                                    br = new cTransaksi(String.valueOf(kode), nama,brg3,  jumlah, 0);
                                }   
                                beli.tambahTransaksi(br);
                                break;
                            case 2 :
                                //hapus transaksi
                                beli.lihatTransaksi();
                                System.out.print("Hapus Nomor = ");
                                int hapus = sc.nextInt( );
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3 :
                                beli.lihatTransaksi();
                                break;
                            case 4 :
                                //selesi. sambungkan transaksi pembeli
                                //ke antrian toko
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Selamat datang kembali..");
                                break;                                
                        }
                    }while(pilih2!=4);
                    break;
                case 2:
                    //anggota
                    break;
                case 3:
                    //admin
                    jual.lihatTransaksi();
                    //memproses tiap transaksi yang belum diproses
                    cTransaksi t= jual.getFront();
                    do{
                        if (t.getStatus()==0) {
                            System.out.println("Kode    : "+t.getKode());
                            System.out.println("Pembeli : "+t.getPembeli());
                            System.out.println("Barang  : "+t.getBarang().getNama());
                            System.out.println("Jumlah  : "+t.getJumlah());
                            System.out.println("Pilih Aksi-");
                            System.out.println("1. Diproses");
                            System.out.println("2. Selesai");
                            System.out.print("Pilih = ");
                            int aksi=sc.nextInt();
                            if (aksi==1) {
                                jual.prosesTransaksi(t);
                                System.out.println("Berhasil diproses....");
                            }
                            else{
                                break;
                            }
                        }
                        t=t.next;
                   }while(t!=null);
                    break;
                case 4:
                    //pemilik
                    //melihat embelian yang sudah dproses
                    System.out.println("Transaksi Diproses : "+jual.lihatDiproses());
                    System.out.println("Pemasukan          : "+jual.lihatPemasukan());
                    break;
                case 5:
                    //exit
                    System.out.println("Terimakasih....");
                    break;                    
            }
        }while(pilih!=5);
    }
}
