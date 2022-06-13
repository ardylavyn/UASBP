
package FinalProjectUAS;
import java.util.Scanner;
public class appToko {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //daftar barang yang dijual
        cBarang brg1 = new cBarang("Tas", 100000);
        cBarang brg2 = new cBarang("Sandal", 150000);
        cBarang brg3 = new cBarang("Sepatu", 200000);  
        //data member toko
        int id1 = 111, pwd1 = 123;
        int id2 = 112, pwd2 = 1234;
        int id3 = 113, pwd3 = 1235;
        int id, pin, pin2;
        int confirm;
        String ya = null;
        String tidak;
        //daftar antrian transaksi yang masuk toko
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
                    boolean valid=false;
                    do {
                        System.out.print("ID  = ");
                        id=sc.nextInt();
                        System.out.print("PIN = ");
                        pin=sc.nextInt();
                        if(id==id1 && pin==pwd1) {
                            valid=true;
                        }
                        else if(id==id2 && pin==pwd2){
                            valid=true;
                        }
                        else if(id==id3 && pin==pwd3){
                            valid=true;
                        }
                        if(valid==false) {
                            int pb = 0;
                            System.out.println("PIN/ID salah!");
                            System.out.println("Ubah Password? Ya(1)/tidak(2)");
                            System.out.print("Pilih = ");
                            confirm=sc.nextInt();
                            if(confirm==1) {
                                boolean benar=false;
                                do {
                                    System.out.print("Masukkan ID kembali = ");
                                    id=sc.nextInt();
                                    if (id==id1) {
                                        benar=true;
                                        System.out.print("Masukkan PIN lama = ");
                                        pin=sc.nextInt();
                                        if(pin!=pwd1) {
                                            System.out.println("Anda salah memasukkan PIN lama");
                                        }
                                        if (pin==pwd1) {
                                            System.out.print("Masukkan PIN baru = ");
                                            pin2 = sc.nextInt();
                                            pb=pin2;
                                        }
                                    }
                                    else if(id==id2){
                                        benar=true;
                                        System.out.print("Masukkan PIN lama = ");
                                        pin=sc.nextInt();
                                        if(pin!=pwd2) {
                                            System.out.println("Anda salah memasukkan PIN lama");
                                        }
                                        if (pin==pwd2) {
                                            System.out.print("Masukkan PIN baru = ");
                                            pin2 = sc.nextInt();
                                            pb=pin2;
                                        }
                                    }
                                    else if(id==id3){
                                        benar=true;
                                        System.out.print("Masukkan PIN lama = ");
                                        pin=sc.nextInt();
                                        if(pin!=pwd3) {
                                            System.out.println("Anda salah memasukkan PIN lama");
                                        }
                                        if (pin==pwd3) {
                                            System.out.print("Masukkan PIN baru = ");
                                            pin2 = sc.nextInt();
                                            pb=pin2;
                                        }
                                    }
                                    System.out.println("Mohon masukkan data baru");
                                    do {
                                        System.out.print("ID  = ");
                                        id=sc.nextInt();
                                        System.out.print("PIN = ");
                                        pin=sc.nextInt();
                                        if(id==id1 && pin==pb) {
                                            valid=true;
                                        }
                                        else if(id==id2 && pin==pb){
                                            valid=true;
                                        }
                                        else if(id==id3 && pin==pb){
                                            valid=true;
                                        }
                                    } while (valid==false);  
                                } while (benar=false);
                            }
                            else if(confirm==2){
                                System.out.println("Baiklah...");
                            }   
                        }
                    } while(valid==false);
                    if (valid==true) {
                        System.out.println("Selamat Datang...");
                        kode++;
                        beli = new cDaftarTransaksi();
                        do{
                            System.out.println("Akun Member");
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
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg1, jumlah, 0);
                                    }
                                    else if (pilih3==2) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg2, jumlah, 0);
                                    }
                                    else if (pilih3==3) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg3, jumlah, 0);
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
                                    //menampilkan daftar belanja dan diskon^
                                    beli.lihatTransaksiMember();
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
                    }
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
                    //melihat pembelian yang sudah dproses
                    System.out.println("Akun Pemilik");
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
