package vehicle;

public class Truck extends Vehicle {

    //final - означает что переменная меняться только один раз при вызове конструктора
    private final boolean hasTrailer;

    public Truck(String id, double maxCapacityKg, boolean hasTrailer) {
        super(id, hasTrailer ? maxCapacityKg + 5000.0 : maxCapacityKg);
        // ? - тогда, : - иначе
        this.hasTrailer = hasTrailer;
    }


    @Override
    public void move() {

    }

    public boolean getHasTrailer() {
        return hasTrailer;
    }

}
