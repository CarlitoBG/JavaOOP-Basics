package p06_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String type = reader.readLine();
            if ("Beast!".equals(type)){
                break;
            }

            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            Animal animal;
            try {
                switch (type){
                    case "Animal":
                        animal = new Animal(name, age, gender);
                        break;
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age, gender);
                        break;
                    default:
                        animal = null;
                }

                if (animal == null){
                    System.out.println(Messages.INVALID_INPUT);
                }else {
                    System.out.println(animal.toString());
                }
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }
}