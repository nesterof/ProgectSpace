package Factory;

import java.util.HashMap;

/**
 * Created by ness on 12.05.2015.
 */
public class Dealer extends Thread {
    private Storage storage;
    private Integer ntime;
    private long firsttime;
    public Dealer(Integer ntime, HashMap storages){
        this.storage= (Storage) storages.get("car");
        this.ntime=ntime*1000;
        firsttime=System.currentTimeMillis();
    }
    public void run() {
        while (true) {
            if (System.currentTimeMillis() - firsttime > ntime) {
                firsttime = System.currentTimeMillis();
                synchronized (storage) {
                    if (storage.isEmpty()) {
                        try {
                            storage.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    storage.getDetail();
                    System.out.println("sell");
                }
            }
        }
    }
}
