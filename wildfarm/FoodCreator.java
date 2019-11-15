package wildfarm;

public class FoodCreator {
    public static Food create (String line) {
        String[] tokens = line.split("\\s+");
        String type = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        if (type.equals("Vegetable")) {
            return new Vegetable(quantity);
        } else {
            return new Meat(quantity);
        }
    }
}
