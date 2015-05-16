package Factory;

/**
 * Created by ness on 07.05.2015.
 */
public class Supplier extends Thread{
    private int ntime;
    private long firsttime;
    private boolean ready=false;
    private String type;
    private Storage storage;
    public Supplier(int n, Storage storage, String string){
        super();
        this.storage=storage;
        this.type=string;
        ntime=n*1000;
        firsttime=System.currentTimeMillis();
    }

    public void run(){
        while (true) {
            if (System.currentTimeMillis() - firsttime > ntime) {
                firsttime=System.currentTimeMillis();
                synchronized (storage) {
                    if (storage.isFulness()) {
                        try {
                            System.out.println("suplier wait");
                            storage.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("suplier go");
                    }
                    storage.notifyAll();
                    storage.setDetail(new Detail(type));
                    firsttime = System.currentTimeMillis();
                }
            }
        }
    }

}
