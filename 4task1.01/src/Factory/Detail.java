package Factory;

/**
 * Created by ness on 07.05.2015.
 */
public class Detail {
    protected int id=0;
    protected String type;
    public Detail(){};
    public Detail(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }
    public void setID(int id ){
        this.id=id;
    }
    public int getID() {
        return id;
    }
}
