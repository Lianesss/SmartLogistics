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
        System.out.println("Легковое авто "+getId()+" едет по дороге со скоростью 90 км/ч");
    }

    public int getPassengerCount() {
        return passengerCount;
    }
}
