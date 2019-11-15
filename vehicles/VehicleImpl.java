package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private final DecimalFormat formatter = new DecimalFormat("#.##");

    public VehicleImpl(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void drive(Double distance) {
        if (canDrive(distance)) {
            this.fuelQuantity -= this.fuelConsumption * distance;
            System.out.println(String.format(" travelled %s km",
                    formatter.format(distance)));
        } else {
            System.out.println(" needs refueling");
        }
    }

    public boolean canDrive(Double distance) {
        return this.fuelQuantity >= this.fuelConsumption * distance;
    }

    @Override
    public void refuel(Double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format(" %.2f", this.fuelQuantity);
    }
}
