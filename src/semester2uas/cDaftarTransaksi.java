
package FinalProjectUAS;

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
        System.out.println("Mendapatkan diskon 10%");
        System.out.println("Total Belanja : "+total);
        System.out.println("Diskon        : "+(0.1*total));
        System.out.println("Biaya Akhir   : "+(total-(0.1*total)));
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
    public double lihatPemasukan(){
        cTransaksi t=front;
        double nominal=0;
        for (;t!=null; t=t.next) {
            if (t.getStatus()==1) {
                //cek memberberdasarkan data nama/kode pembeli
                nominal=nominal+t.getBarang().getHarga()*t.getJumlah();
                if (t.getPembeli().compareToIgnoreCase("111")==0) {
                    System.out.println("Member!");
                    nominal=nominal-(0.1*nominal);
                }
             }
        }
        return nominal;
    }
}
        
