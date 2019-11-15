package wildfarm;

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

        List<Animal> list = new ArrayList<>();

        String input;

        while (!"End".equals(input = reader.readLine())) {

            Animal animal = AnimalCreator.create(input);
            Food food = FoodCreator.create(reader.readLine());
            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            list.add(animal);

        }

        for (Animal animal : list) {
            System.out.println(animal);
        }

    }
}
