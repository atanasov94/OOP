package bordercontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String input;
        List<Identifiable> list = new ArrayList<>();

        while (!"END".equalsIgnoreCase(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 3) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                list.add(citizen);
            } else {
                Robot robot = new Robot(tokens[0], tokens[1]);
                list.add(robot);
            }
        }

        String end = reader.readLine();

        for (Identifiable identifiable : list) {
            if (identifiable.getId().endsWith(end)) {
                System.out.println(identifiable.getId());
            }
        }

    }
}
