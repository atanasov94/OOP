package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String[] carTokens = reader.readLine().split("\\s+");
        double carFuel = Double.parseDouble(carTokens[1]);
        double carConsumption = Double.parseDouble(carTokens[2]);
        double carCapacity = Double.parseDouble(carTokens[3]);
        Car car = new Car(carFuel, carConsumption, carCapacity);

        String[] truckTokens = reader.readLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckTokens[1]);
        double truckConsumption = Double.parseDouble(truckTokens[2]);
        double truckCapacity = Double.parseDouble(truckTokens[3]);
        Truck truck = new Truck(truckFuel, truckConsumption, truckCapacity);

        String[] busTokens = reader.readLine().split("\\s+");
        double busFuel = Double.parseDouble(busTokens[1]);
        double busConsumption = Double.parseDouble(busTokens[2]);
        double busCapacity = Double.parseDouble(busTokens[3]);
        Bus bus = new Bus(busFuel, busConsumption, busCapacity);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];
            double value = Double.parseDouble(input[2]);

            switch (command) {
                case "Drive" :
                    if (vehicle.equals("Car")) {
                        System.out.println(car.drive(value));
                    } else if (vehicle.equals("Truck")){
                        System.out.println(truck.drive(value));
                    } else {
                        System.out.println(bus.drive(value));
                    }
                    break;
                case "Refuel" :
                    try {
                        if (vehicle.equals("Car")) {
                            car.refuel(value);
                        } else if (vehicle.equals("Truck")) {
                            truck.refuel(value);
                        } else {
                            bus.refuel(value);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty" :
                    System.out.println(bus.driveEmpty(value));
                default:break;
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));
    }
}
