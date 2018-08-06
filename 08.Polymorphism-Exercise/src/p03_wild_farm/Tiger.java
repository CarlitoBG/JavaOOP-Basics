package p03_wild_farm;

public class Tiger extends Felime{

    private String livingRegion;

    Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    protected String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    protected void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }
}