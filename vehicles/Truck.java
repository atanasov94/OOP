package vehicles;

import java.text.DecimalFormat;

public class Truck implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double capacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm + 1.6;
        this.tankCapacity = capacity;
    }

    @Override
    public String drive(double distance) {
        if (this.fuelQuantity >= this.fuelConsumptionPerKm * distance) {
            this.setFuelQuantity(this.fuelQuantity - this.fuelConsumptionPerKm * distance);
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("Truck travelled %s km",
                    df.format(distance));
        }
        return "Truck needs refueling";
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + 0.95 * liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity() + 0.95 * liters);
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
}
