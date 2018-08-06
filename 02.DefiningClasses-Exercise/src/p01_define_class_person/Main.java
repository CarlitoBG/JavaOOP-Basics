package p01_define_class_person;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {

        Class person = Person.class;

        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);

        Person pesho = new Person();
        pesho.setName("Pesho");
        pesho.setAge(18);

        Person gosho = new Person("Gosho", 22);

        Person stamat = new Person(){{
            setName("Stamat");
            setAge(43);
        }};
    }
}