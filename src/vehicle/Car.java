package vehicle;

// extends - является наследником
public class Car extends Vehicle {

    private int passengerCount;

    public Car(String id, int passengerCount){
        // super - вызов конструктора родителя
        super(id, 500.0);
        this.passengerCount=passengerCount;

    }

    @Override
    public void move(){

    }

    public int getPassengerCount() {
        return passengerCount;
    }
}
