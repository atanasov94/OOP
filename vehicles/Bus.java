package vehicles;

import java.text.DecimalFormat;

public class Bus implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double fuelConsumptionPerKmEmpty;
    private double tankCapacity;

    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double capacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm + 1.4;
        this.fuelConsumptionPerKmEmpty = fuelConsumptionPerKm;
        this.tankCapacity = capacity;
    }

    @Override
    public String drive(double distance) {
        if (this.fuelQuantity >= this.fuelConsumptionPerKm * distance) {
            this.setFuelQuantity(this.fuelQuantity - this.fuelConsumptionPerKm * distance);
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("Bus travelled %s km",
                    df.format(distance));
        }
        return "Bus needs refueling";
    }

    public String driveEmpty(double distance) {
        if (this.fuelQuantity >= this.fuelConsumptionPerKmEmpty * distance) {
            this.setFuelQuantity(this.fuelQuantity - this.fuelConsumptionPerKmEmpty * distance);
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("Bus travelled %s km",
                    df.format(distance));
        }
        return "Bus needs refueling";
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > this.tankCapacity) {
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

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
