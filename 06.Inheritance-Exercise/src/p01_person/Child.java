package p01_person;

public class Child extends Person{

    private static final String AGE_ERROR_MESSAGE = "Child's age must be lesser than 15!";

    Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15){
            throw new IllegalArgumentException(AGE_ERROR_MESSAGE);
        }
        super.setAge(age);
    }
}