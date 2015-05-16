package Factory;

import java.util.HashMap;

/**
 * Created by ness on 10.05.2015.
 */
public class Worker extends Thread{
    private Integer ntime;

    private Detail body = null;
    private Detail engine = null;
    private Detail accessory = null;
    private HashMap<String, Storage> storages=new HashMap<String,Storage>();
    private long firsttime;
    public Worker(Integer n,HashMap storages){
        super();
        firsttime=System.currentTimeMillis();
        this.ntime=n*1000;
        this.storages=storages;
    }
    public void run() {
        while (true) {
            if (System.currentTimeMillis() - firsttime > ntime) {
                firsttime=System.currentTimeMillis();
                synchronized (storages.get("accessory")) {
                    while (storages.get("accessory").isEmpty()) {
                        try {
                            storages.get("accessory").wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    accessory = storages.get("accessory").getDetail();
                    System.out.println("access");
                }
                synchronized (storages.get("body")) {
                    while (storages.get("body").isEmpty()) {
                        try {
                            System.out.println("worker wait");
                            storages.get("body").wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("worker go");
                    body = storages.get("body").getDetail();
                    System.out.println("body");
                }
                synchronized (storages.get("engine")) {
                    while (storages.get("engine").isEmpty()) {
                        try {
                            storages.get("engine").wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    engine = storages.get("engine").getDetail();
                    System.out.println("engine");
                }
                if (body != null && engine != null && accessory != null) {
                    synchronized (storages.get("car")) {
                        while (storages.get("car").isFulness()){
                            try {
                                storages.get("car").wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        storages.get("car").setDetail(new Car(accessory, body, engine));
                        body = null;
                        engine = null;
                        accessory = null;
                    }
                }
            }
        }
    }
}
