
package FinalProjectUAS;
public class cDaftarTransaksi {
    cTransaksi front, rear;
    int jumlah;
    cDaftarTransaksi(){
        front=rear=null;
        jumlah=0;
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
        System.out.println("Daftar Transaksi:");
        for (cTransaksi t = front; t!=null; t=t.next) {
            System.out.print(i + ".");            
            System.out.print(t.getKode() + "-");
            System.out.print(t.getPembeli()+ "-");  
            System.out.print(t.getBarang() .getNama()+ "-");
            System.out.print(t.getJumlah());           
            System.out.print(t.getStatus());          
        }
    }
}
