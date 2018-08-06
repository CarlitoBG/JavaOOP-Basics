package p03_wild_farm;

import static p03_wild_farm.Main.DECIMAL_FORMAT;

public class Cat extends Felime{

    private String breed;

    Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    protected String makeSound() {
        return "Meowwww";
    }

    @Override
    protected void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getBreed(),
                DECIMAL_FORMAT.format(super.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
    }
}