package p04_mordors_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foodsEaten = reader.readLine().split("\\s+");

        Wizard wizard = new Wizard();

        List<Food> foods = new ArrayList<>();
        for (String food : foodsEaten) {
            foods.add(new Food(food));
        }

        wizard.eatAll(foods);

        System.out.println(wizard.toString());
    }
}