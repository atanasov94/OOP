package classbox;

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

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        List<Box> boxes = new ArrayList<>();

        try {
            Box box = new Box(length, width, height);
            boxes.add(box);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for (Box box : boxes) {
            System.out.println(String.format("Surface Area - %.2f",
                    box.calculateSurfaceArea()));
            System.out.println(String.format("Lateral Surface Area - %.2f",
                    box.calculateLateralSurfaceArea()));
            System.out.println(String.format("Volume - %.2f",
                    box.calculateVolume()));
        }

    }
}
