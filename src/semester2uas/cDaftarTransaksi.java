package project_uas;
public class cDaftarTransaksi {
    //depan dan belakang
    //depan untuk eksekusi
    //belakang untuk keperluan masuknya transaksi
    cTransaksi front, rear;
    int jumlah;
    cDaftarTransaksi(){
        front=rear=null;
        jumlah=0;
    }
    public cTransaksi getFront(){
        return front;
    }
    public cTransaksi getRear(){
        return rear;
    }
    public void tambahTransaksi(cTransaksi baru){
        if(rear==null){
            front=rear=baru;
        }
        else{
            rear.next=baru;
            rear=baru;
        }
        System.out.println("Penambahan sukses..");
    }
    public void lihatTransaksi(){
        int i=1;
        System.out.println("Daftar Transaksi : ");
        for (cTransaksi t = front; t!=null; t=t.next) {
            System.out.print(i + ".");            
            System.out.print(t.getKode()+ "-");
            System.out.print(t.getPembeli()+ "-");  
            System.out.print(t.getBarang().getNama()+ "-");
            System.out.print(t.getJumlah()+"-");           
            System.out.println(t.getStatus()); 
            i++;
        }
        System.out.println("");
    }
    public void lihatTransaksiMember(){
        int i=1;
        double total=0,diskon;
        System.out.println("Daftar Transaksi Member : ");
        for (cTransaksi t = front; t!=null; t=t.next) {
            System.out.print(i + ".");            
            System.out.print(t.getKode()+ "-");
            System.out.print(t.getPembeli()+ "-");  
            System.out.print(t.getBarang().getNama()+ "-");
            System.out.print(t.getJumlah()+"-");           
            System.out.println(t.getStatus()); 
            i++;
            total=total+(t.getBarang().getHarga()*t.getJumlah());
        }
        System.out.println("Mendapatkan diskon 5%");
        System.out.println("Total Belanja : "+total);
        System.out.println("Diskon        : "+(0.05*total));
        System.out.println("Biaya Akhir   : "+(total-(0.05*total)));
        System.out.println("");
    }
    public void hapusTransaksi(int nomor){
        cTransaksi t=front;
        cTransaksi prev=null;
        int i=1;
        if (nomor==1) {//hapus posisi terdepan
            if (t.next==null) {
                front=rear=null;
             }
            else{
            front=front.next;
            t.next=null;
           }
            System.out.println("["+t.getBarang().getNama()+"] dihapus...");
        }
    else{ //hapus posisi tengah
        for (; t!=null ; t=t.next) {
        if (i==nomor) {
            break;
      }
         i++;
         prev=t;
      }
        //yg dihapus di uung belakang
        if(t.next==null){
            rear=prev;
            rear.next=null;
        }
        else{
            prev.next=t.next;
            t.next=null;
        }
            System.out.println("["+t.getBarang().getNama()+"] dihapus...");
      }
    }
    public void sambungTransaksi(cTransaksi depan, cTransaksi belakang){
        //sambung transaksi
        if (rear==null) { //transaksi masih kosong
            front=depan;
            rear=belakang;
        }
        else{
            rear.next=depan;
            //update posisi rare
            rear=belakang;
        }
        
    }
    public void prosesTransaksi(cTransaksi t){
        //cek member
        t.setStatus(1);
    }
    
    public void belumTransaksi(cTransaksi t){
        t.setStatus(0);
    }
    public void prosesTransaksiMember(cTransaksi t){
        //mendapatkan diskon
    }
    public int lihatDiproses(){
        cTransaksi t=front;
        int proses=0;
        for (;t!=null; t=t.next) {
            if (t.getStatus()==1) {
                proses++;
            }
        }
        return proses;
     }
    
    public int sedangDiproses(){
        cTransaksi t=front;
        int proses=0;
        for (;t!=null; t=t.next) {
            if (t.getStatus()==0) {
                proses++;
            }
        }
        return proses;
     }
    
    public double lihatPemasukan(){
        int i=1;
        double harga=0, total1=0;
        System.out.println("=======================================================================");
        System.out.println("\t\tDAFTAR TRANSAKSI SUDAH DIPROSES\t\t");
        System.out.println("=======================================================================");
        System.out.println("No. \tKODE \tPEMBELI \tBARANG \t\tJUMLAH \tHARGA \t\t\tSTATUS");
        System.out.println("=======================================================================");
        for (cTransaksi t=front; t!=null; t=t.next) {
            if (t.getStatus()==1) {
                System.out.print(i+".");
                System.out.print("\t"+t.getKode()+"\t");
                System.out.print(t.getPembeli()+"\t ");
                System.out.print(t.getBarang().getNama()+"\t");
                System.out.print(t.getJumlah()+"\t");
                System.out.print(t.getBarang().getHarga()+"(Disc 5%)\t\t");
                System.out.println(t.getStatus());
                i++;
                total1=total1+(t.getBarang().getHarga()*t.getJumlah());
                if (t.getPembeli().compareToIgnoreCase("111")==0 || t.getPembeli().compareToIgnoreCase("112")==0 || t.getPembeli().compareToIgnoreCase("113")==0) {
                    total1=total1-(0.05*total1);
                }
            }
        }  
        return total1;
    }
    
    public double lihatPemasukan2(){
        int i=1;
        double harga=0, total1=0;
        System.out.println("=======================================================================");
        System.out.println("\t\tDAFTAR TRANSAKSI BELUM DIPROSES\t\t");
        System.out.println("=======================================================================");
        System.out.println("No. \tKODE \tPEMBELI \tBARANG \t\tJUMLAH \tHARGA \t\t\tSTATUS");
        System.out.println("=======================================================================");
        for (cTransaksi t=front; t!=null; t=t.next) {
            if (t.getStatus()==0) {
                System.out.print(i+".");
                System.out.print("\t"+t.getKode()+"\t");
                System.out.print(t.getPembeli()+"\t ");
                System.out.print(t.getBarang().getNama()+"\t");
                System.out.print(t.getJumlah()+"\t");
                System.out.print(t.getBarang().getHarga()+"\t\t");
                System.out.println(t.getStatus());
                i++;
                total1=total1+(t.getBarang().getHarga()*t.getJumlah());
                if (t.getPembeli().compareToIgnoreCase("111")==0 || t.getPembeli().compareToIgnoreCase("112")==0 || t.getPembeli().compareToIgnoreCase("113")==0) {
                    total1=total1-(0.05*total1);
                }
            }
        }  
        return total1;
    }
}
