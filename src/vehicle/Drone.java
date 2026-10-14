package vehicle;

public class Drone extends Vehicle {
    private double latitude;
    private double longitude;
    private double altitude;

    private int batteryLevel;

    public Drone(String id) {
        super(id, 5.0);
        this.batteryLevel = 100;
    }

    @Override
    public void move() {
        latitude+=0.1;
        longitude+=0.1;
        altitude+=0.1;
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
