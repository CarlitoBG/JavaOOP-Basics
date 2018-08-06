package paw_inc.entities.centers;

import paw_inc.entities.animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Center {

    private String name;
    private List<Animal> animals;

    protected Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void register(Animal animal){
        this.animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(this.animals);
    }

    public List<Animal> getUncleansedAnimals(){
        return this.getAnimals().stream().filter(a -> !a.isCleansed()).collect(Collectors.toList());
    }

    public List<Animal> getCleansedAnimals(){
        return this.getAnimals().stream().filter(Animal::isCleansed).collect(Collectors.toList());
    }

    public void sendForCleansing(List<Animal> uncleansedAnimals) {
        this.animals.addAll(uncleansedAnimals);
    }

    public void removeUncleansedAnimals() {
        this.animals.removeAll(this.getUncleansedAnimals());
    }

    public void cleanse() {
        for (Animal animal : this.animals) {
            animal.setCleansed(true);
        }
    }

    public void clearStoredAnimals() {
        this.animals = new ArrayList<>();
    }

    public void removeAnimals(List<Animal> animals) {
        this.animals.removeAll(animals);
    }

    public void sendForCastration(CastrationCenter castrationCenter){
        for (Animal animal : this.getUncleansedAnimals()) {
            castrationCenter.register(animal);
        }
        this.animals.removeAll(this.getUncleansedAnimals());
    }
}