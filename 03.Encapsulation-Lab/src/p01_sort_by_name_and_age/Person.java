package p01_sort_by_name_and_age;

public class Person {

    private String firstName;
    private String lastName;
    private Integer age;

    Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    String getFirstName() {
        return this.firstName;
    }

    Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " is " + this.age + " years old.";
    }
}