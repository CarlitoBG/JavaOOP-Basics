package paw_inc.core;

import paw_inc.entities.animals.Animal;
import paw_inc.entities.animals.Cat;
import paw_inc.entities.animals.Dog;
import paw_inc.entities.centers.AdoptionCenter;
import paw_inc.entities.centers.CastrationCenter;
import paw_inc.entities.centers.Center;
import paw_inc.entities.centers.CleansingCenter;
import paw_inc.factories.AnimalFactory;
import paw_inc.factories.CenterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, CastrationCenter> castrationCenters;

    private List<Animal> adoptedAnimals;
    private List<Animal> cleansedAnimals;
    private List<Animal> castratedAnimals;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.castrationCenters = new HashMap<>();
        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
        this.castratedAnimals= new ArrayList<>();
    }

    public void registerCleansingCenter(String name){
        CleansingCenter cleansingCenter = CenterFactory.createCleansingCenter(name);
        this.cleansingCenters.putIfAbsent(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name){
        AdoptionCenter adoptionCenter = CenterFactory.createAdoptionCenter(name);
        this.adoptionCenters.putIfAbsent(name, adoptionCenter);
    }

    public void registerCastrationCenter(String castrationCenterName) {
        CastrationCenter castrationCenter = CenterFactory.createCastrationCenter(castrationCenterName);
        this.castrationCenters.putIfAbsent(castrationCenterName, castrationCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        Dog dog = AnimalFactory.createDog(name, age, learnedCommands, adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).register(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        Cat cat = AnimalFactory.createCat(name, age, intelligenceCoefficient, adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
        this.cleansingCenters.get(cleansingCenterName).sendForCleansing(this.adoptionCenters.get(adoptionCenterName).getUncleansedAnimals());
        this.adoptionCenters.get(adoptionCenterName).removeUncleansedAnimals();
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCastration(castrationCenter);
    }

    public void cleanse(String cleansingCenterName){
        Center cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        cleansingCenter.cleanse();

        for (Animal animal : cleansingCenter.getAnimals()) {
            this.adoptionCenters.get(animal.getAdoptionCenter()).register(animal);
            this.cleansedAnimals.add(animal);
        }

        this.cleansingCenters.get(cleansingCenterName).clearStoredAnimals();
    }

    public void adopt(String adoptionCenterName){
        Center adoptionCenter = this.adoptionCenters.get(adoptionCenterName);

        this.adoptedAnimals.addAll(adoptionCenter.getCleansedAnimals());
        adoptionCenter.removeAnimals(adoptionCenter.getCleansedAnimals());
    }

    public void printStatistics(){
        StringBuilder sb = new StringBuilder();

        sb.append("Paw Incorporative Regular Statistics\n")
                .append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()))
                .append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()))
                .append(String.format("Adopted Animals: %s\n", getSortedAnimals(this.adoptedAnimals)))
                .append(String.format("Cleansed Animals: %s\n", getSortedAnimals(this.cleansedAnimals)))
                .append(String.format("Animals Awaiting Adoption: %d\n", getAwaitingAdoptionCount()))
                .append(String.format("Animals Awaiting Cleansing: %d\n", getAwaitingCleansingCount()));

        System.out.println(sb.toString());
    }

    private String getSortedAnimals(List<Animal> animals) {
        if (animals.isEmpty()){
            return "None";
        }

        List<String> sorted = animals
                .stream()
                .map(Animal::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        return String.join(", ", sorted);
    }

    private int getAwaitingAdoptionCount() {
        int result = 0;

        for (Map.Entry<String, AdoptionCenter> entry : adoptionCenters.entrySet()) {
            result += entry.getValue().getCleansedAnimals().size();
        }

        return result;
    }

    private int getAwaitingCleansingCount() {
        int result = 0;

        for (Map.Entry<String, CleansingCenter> entry : cleansingCenters.entrySet()) {
            result += entry.getValue().getUncleansedAnimals().size();
        }

        return result;
    }

    public void castrate(String castrationCenterName) {
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);

        for (Animal animal : castrationCenter.getAnimals()) {
            this.adoptionCenters.get(animal.getAdoptionCenter()).register(animal);
            this.castratedAnimals.add(animal);
        }

        this.castrationCenters.get(castrationCenterName).removeAnimals(castrationCenter.getAnimals());
    }

    public void castrationStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Inc. Regular Castration Statistics\n")
                .append(String.format("Castration Centers: %d\n", this.castrationCenters.size()))
                .append(String.format("Castrated Animals: %s", getSortedAnimals(this.castratedAnimals)));

        System.out.println(sb.toString());
    }
}