package paw_inc.factories;

import paw_inc.entities.animals.Cat;
import paw_inc.entities.animals.Dog;

public final class AnimalFactory {

    public static Dog createDog(String name, int age, int commands, String adoptionCenter){
        return new Dog(name, age, adoptionCenter, commands);
    }

    public static Cat createCat(String name, int age, int coefficient, String adoptionCenter){
        return new Cat(name, age, adoptionCenter, coefficient);
    }
}