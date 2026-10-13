package vehicle;

public class Drone extends Vehicle {

    private int batteryLevel;

    public Drone(String id) {
        super(id, 5.0);
        this.batteryLevel = 100;
    }

    @Override
    public void move() {

        if (batteryLevel >= 5) {
            batteryLevel -= 5;
        } else {
            batteryLevel = 0;
        }

        System.out.println("Дрон " + getId() + " летит по воздуху, заряд батареи:" + batteryLevel + "%");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}
