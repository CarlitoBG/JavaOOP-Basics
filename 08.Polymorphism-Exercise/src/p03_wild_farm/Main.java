package p03_wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String PATTERN = "#.##";
    static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(PATTERN);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String line;
        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }

            String[] animalTokens = line.split("\\s+");
            Animal animal = getAnimal(animalTokens);

            String[] foodTokens = reader.readLine().split("\\s+");
            Food food = getFood(foodTokens);

            if (animal != null && food != null) {
                System.out.println(animal.makeSound());
                try {
                    animal.eat(food);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
                animals.add(animal);
            }
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Animal getAnimal(String[] animalTokens) {
        switch (animalTokens[0]) {
            case "Cat":
                return new Cat(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3], animalTokens[4]);
            case "Tiger":
                return new Tiger(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
            case "Zebra":
                return new Zebra(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
            case "Mouse":
                return new Mouse(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
            default:
                return null;
        }
    }

    private static Food getFood(String[] foodTokens) {
        switch (foodTokens[0]) {
            case "Vegetable":
                return new Vegetable(Integer.parseInt(foodTokens[1]));
            case "Meat":
                return new Meat(Integer.parseInt(foodTokens[1]));
            default:
                return null;
        }
    }
}