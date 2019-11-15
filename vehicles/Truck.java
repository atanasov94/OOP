package vehicles;

public class Truck extends VehicleImpl {
    public static final Double AC_EXTRA_CONSUMPTION = 1.6;
    public static final String CLAZZ_NAME = "Truck";

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_EXTRA_CONSUMPTION);
    }

    @Override
    public void refuel(Double liters) {
        super.refuel(0.95 * liters);
    }

    @Override
    public void drive(Double distance) {
        System.out.print(CLAZZ_NAME);
        super.drive(distance);
    }

    @Override
    public String toString() {
        System.out.print(CLAZZ_NAME);
        return super.toString();
    }
}
