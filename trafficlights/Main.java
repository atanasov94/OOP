package trafficlights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        TrafficLights[] trafficLights = Arrays.stream(reader.readLine().split("\\s+"))
                .map(TrafficLights::valueOf)
                .toArray(TrafficLights[]::new);

        int n = Integer.parseInt(reader.readLine());
        TrafficLights[] lights = TrafficLights.values();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                int index = (trafficLights[j].ordinal() + 1) % lights.length;
                trafficLights[j] = lights[index];
                System.out.print(trafficLights[j] + " ");
            }
            System.out.println();
        }

    }

}
