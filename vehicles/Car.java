package vehicles;

import java.text.DecimalFormat;

public class Car implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    public Car(double fuelQuantity, double fuelConsumptionPerKm, double capacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm + 0.9;
        this.tankCapacity = capacity;
    }

    @Override
    public String drive(double distance) {
        if (this.fuelQuantity >= this.fuelConsumptionPerKm * distance) {
            this.setFuelQuantity(this.fuelQuantity - this.fuelConsumptionPerKm * distance);
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("Car travelled %s km",
                    df.format(distance));
        }
        return "Car needs refueling";
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.fuelQuantity + liters);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
