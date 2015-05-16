package Factory;

/**
 * Created by ness on 10.05.2015.
 */
public class Car extends Detail{
    private Detail body;
    private Detail acessory;
    private Detail engine;
    public Car(Detail acessory, Detail body, Detail engine){
        super();
        this.type="car";
        System.out.println("car");
        this.acessory=acessory;
        this.body=body;
        this.engine=engine;
    }

}
