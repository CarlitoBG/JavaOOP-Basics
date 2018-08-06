package p01_person;

public class Person {

    private static final String NAME_ERROR_MESSAGE = "Name's length should not be less than 3 symbols!";
    private static final String AGE_ERROR_MESSAGE = "Age must be positive!";

    private String name;
    private int age;

    Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 3){
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException(AGE_ERROR_MESSAGE);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", this.getName(), this.getAge());
    }
}