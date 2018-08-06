package paw_inc.entities.animals;

public class Cat extends Animal{

    private int intelligenceCoefficient;

    public Cat(String name, int age, String adoptionCenter, int intelligenceCoefficient) {
        super(name, age, adoptionCenter);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }
}