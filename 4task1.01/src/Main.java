import Factory.Dealer;
import Factory.Storage;
import Factory.Supplier;
import Factory.Worker;

import java.util.HashMap;

/**
 * Created by ness on 07.05.2015.
 */
public class Main {
    public static void main(String[] args){
        HashMap<String,Storage> storages=new HashMap<String,Storage>();
        Storage astorage=new Storage(10);
        Supplier supplierA =new Supplier(1, astorage, "accessory");
        storages.put("accessory", astorage);
        supplierA.start();


        Storage bstorage=new Storage(10);
        Supplier supplierB =new Supplier(1, bstorage, "body");
        storages.put("body", bstorage);
        supplierB.start();

        Storage estorage=new Storage(10);
        Supplier supplierE =new Supplier(1, estorage, "engine");
        storages.put("engine", astorage);
        supplierE.start();

        Storage carstorage=new Storage(100);
        storages.put("car", carstorage);
        Worker worker=new Worker(2,storages);
        worker.start();

        Dealer dealer=new Dealer(10, storages);
        dealer.start();

    while (true){

        int i=0;
    }

    }
}
