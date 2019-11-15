package wildfarm;

public class AnimalCreator {
    public static Animal create (String line) {
        String[] tokens = line.split("\\s+");
        String type = tokens[0];
        String name = tokens[1];
        Double weight = Double.parseDouble(tokens[2]);
        String region = tokens[3];

        if (type.equals("Cat")) {
            String breed = tokens[4];
            return new Cat(name, type, weight, region, breed);
        } else if (type.equals("Tiger")) {
            return new Tiger(name, type, weight, region);
        } else if (type.equals("Zebra")) {
            return new Zebra(name, type, weight, region);
        } else {
            return new Mouse(name, type, weight, region);
        }
    }
}
