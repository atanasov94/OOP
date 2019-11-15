package wildfarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;
    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(), this.getAnimalName(), this.breed, formatter.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
