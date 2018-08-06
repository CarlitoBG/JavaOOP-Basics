package paw_inc.entities.animals;

public abstract class Animal {

    private String name;
    private int age;
    private boolean isCleansed;
    private String adoptionCenter;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.isCleansed = false;
    }

    protected Animal(String name, int age, String adoptionCenter) {
       this(name, age);
       this.isCleansed = false;
       this.adoptionCenter = adoptionCenter;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCleansed() {
        return this.isCleansed;
    }

    public void setCleansed(boolean cleansed) {
        isCleansed = cleansed;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }
}