package vehicle;

public class Drone extends Vehicle {

    private int batteryLevel;

    public Drone(String id) {
        super(id, 5.0);


    }

    @Override
    public void move() {
        if (batteryLevel >= 5) {
            batteryLevel -= 5;
        } else {
            batteryLevel = 0;
        }

    }

    public int getBatteryLevel() {
        return batteryLevel;
    }


}
