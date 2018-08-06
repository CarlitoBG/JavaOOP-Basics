package p03_wild_farm;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.setFoodEaten(0);
    }

    String getAnimalName() {
        return animalName;
    }

    String getAnimalType() {
        return animalType;
    }

    double getAnimalWeight() {
        return animalWeight;
    }

    int getFoodEaten() {
        return foodEaten;
    }

    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected abstract String makeSound();

    protected abstract void eat(Food food);
}