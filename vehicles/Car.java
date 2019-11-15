package vehicles;

public class Car extends VehicleImpl {
    public static final Double AC_EXTRA_CONSUMPTION = 0.9;
    public static final String CLAZZ_NAME = "Car";

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_EXTRA_CONSUMPTION);
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
