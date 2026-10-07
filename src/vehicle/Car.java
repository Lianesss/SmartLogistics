package vehicle;

// extends - является наследником
public class Car extends Vehicle {
    public Car(String id, double maxCapacityKg){
        // super - вызов конструктора родителя
        super(id, maxCapacityKg);
    }

    @Override
    public void move(){

    }
}
