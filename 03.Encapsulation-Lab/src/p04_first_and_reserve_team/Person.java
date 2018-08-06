package p04_first_and_reserve_team;

public class Person {

    private String firstName;
    private String secondName;
    private int age;
    private double salary;

    Person(String firstName, String secondName, int age, double salary) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setAge(age);
        this.setSalary(salary);
    }

    int getAge() {
        return this.age;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setSecondName(String secondName) {
        if (secondName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.secondName = secondName;
    }

    private void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.secondName + " gets " + this.salary + " leva";
    }
}