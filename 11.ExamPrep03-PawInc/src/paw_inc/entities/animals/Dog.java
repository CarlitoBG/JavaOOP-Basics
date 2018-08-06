package paw_inc.entities.animals;

public class Dog extends Animal{

    private int amountOfCommands;

    public Dog(String name, int age, String adoptionCenter, int amountOfCommands) {
        super(name, age, adoptionCenter);
        this.amountOfCommands = amountOfCommands;
    }
}