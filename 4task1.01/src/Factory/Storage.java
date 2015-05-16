package Factory;

import java.util.Stack;
import java.util.Vector;

/**
 * Created by ness on 10.05.2015.
 */
public class Storage {
    private Integer size;
    private Integer currentID=0;
    private Stack stackDetail=new Stack<Detail>();
    public Storage(int size){
        this.size=size;
    }
    public void setDetail(Detail detail){
        this.notifyAll();
        detail.setID(currentID);
        currentID++;
        stackDetail.add(detail);

    }
    public boolean isFulness(){
        if(size==stackDetail.size())
            return true;
        else
            return false;
    }
    public boolean isEmpty(){
        if(0==stackDetail.size())
            return true;
        else
            return false;
    }
    public Detail getDetail(){
        this.notifyAll();
        Detail detail= (Detail) stackDetail.pop();
            return detail;
    }
}
