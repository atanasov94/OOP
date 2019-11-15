package wildfarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public abstract void makeSound();
    public abstract void eat(Food food);

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %d]",
                this.animalType, this.animalName, formatter.format(this.animalWeight), this.foodEaten);
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }
}
