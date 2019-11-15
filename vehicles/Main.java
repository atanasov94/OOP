package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        Vehicle vehicle1 = VehicleCreator(reader.readLine());
        Vehicle vehicle2 = VehicleCreator(reader.readLine());

        Map<String, Vehicle> map = new LinkedHashMap<>();
        map.put(vehicle1.getClass().getSimpleName(), vehicle1);
        map.put(vehicle2.getClass().getSimpleName(), vehicle2);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            Double value = Double.parseDouble(input[2]);

            if (command.equals("Drive")) {
                map.get(vehicleType).drive(value);
            } else {
                map.get(vehicleType).refuel(value);
            }
        }
        map.values().forEach(System.out::println);
    }

    private static Vehicle VehicleCreator(String line) {
        String[] tokens = line.split("\\s+");
        return tokens[0].equals("Car") ?
                new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])) :
                new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
    }
}
