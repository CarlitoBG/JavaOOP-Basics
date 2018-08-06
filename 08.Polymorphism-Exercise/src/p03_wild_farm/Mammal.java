package p03_wild_farm;

import static p03_wild_farm.Main.DECIMAL_FORMAT;

public abstract class Mammal extends Animal{

    private String livingRegion;

    Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                DECIMAL_FORMAT.format(super.getAnimalWeight()),
                this.livingRegion,
                super.getFoodEaten());
    }
}