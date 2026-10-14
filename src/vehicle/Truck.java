package vehicle;
import interfaces.ITrackable;

public class Truck extends Vehicle implements ITrackable{

    private double latitude;
    private double longitude;

    //final - означает что переменная меняться только один раз при вызове конструктора
    private final boolean hasTrailer;

    public Truck(String id, double maxCapacityKg, boolean hasTrailer) {
        super(id, hasTrailer ? maxCapacityKg + 5000.0 : maxCapacityKg);
        // ? - тогда, : - иначе
        this.hasTrailer = hasTrailer;
    }


    @Override
    public void move() {
        latitude+=0.1;
        longitude+=0.1;
        System.out.println("Грузовик " + getId() + " едет по трассе со скоростью 70 км/ч");
    }

    public boolean getHasTrailer() {
        return hasTrailer;
    }

    @Override
    public String getCurrentCoordinates() {
        return "";
    }

    @Override
    public void sendStatusUpdate() {

    }
}
