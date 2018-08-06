package p03_wild_farm;

public class Zebra extends Mammal{

    Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "Zs";
    }

    @Override
    protected void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }
}