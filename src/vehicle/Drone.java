package vehicle;

import interfaces.ITrackable;

public class Drone extends Vehicle implements ITrackable {
    private double latitude = 50.2;
    private double longitude = 50.2;
    private double altitude = 20.4;

    private int batteryLevel;

    public Drone(String id) {
        super(id, 5.0);
        this.batteryLevel = 100;
    }

    @Override
    public void move() {
        latitude+=10;
        longitude+=10;
        altitude+=10;
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


    @Override
    public String getCurrentCoordinates() {
        return "Широта: " + latitude + ", Долгота: " + longitude + ", Высота: " + altitude + "м";
    }

    @Override
    public void sendStatusUpdate() {
        System.out.println("Дрон " + getId() + " [GPS стаутс]: " + getCurrentCoordinates());
    }
}
