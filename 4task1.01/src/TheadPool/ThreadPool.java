package TheadPool;

import Factory.Dealer;
import Factory.Storage;
import Factory.Supplier;
import Factory.Worker;

import java.util.HashMap;

/**
 * Created by ness on 12.05.2015.
 */
public class ThreadPool {
    private Thread[] threads;
    public ThreadPool(int number, String type, HashMap storages, int period){
        if(type.equals("Worker")){
            threads=new Thread[number];
            for(int i=0; i<number; i++){
                threads[i]=new Worker(period, storages);
            }
        }
        if(type.equals("Dealer")){
            threads=new Thread[number];
            for(int i=0; i<number; i++){
                threads[i]=new Dealer(period, storages);
            }
        }
        if(type.equals("Supplier")){
            threads=new Thread[number+2];
            for(int i=0; i<number; i++){
                threads[i]=new Supplier(period, (Storage) storages.get("accessory"), "accessory");
            }
            threads[number-2]=new Supplier(period, (Storage) storages.get("body"), "body");
            threads[number-1]=new Supplier(period, (Storage) storages.get("engine"), "engine");
        }
    }
   public void start(){
       for(int i=0; i<threads.length; i++){
           threads[i].start();
       }
   }
}
