package p05_pizza_calories;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line = reader.readLine().split("\\s+");
            String pizzaName = line[1];
            int numberOfToppings = Integer.parseInt(line[2]);

            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            line = reader.readLine().split("\\s+");
            String flourType = line[1];
            String bakingTechnique = line[2];
            int doughWeightInGrams = Integer.parseInt(line[3]);

            Dough dough = new Dough(flourType, bakingTechnique, doughWeightInGrams);
            pizza.setDough(dough);

            while (true){
                line = reader.readLine().split("\\s+");
                if("END".equals(line[0])) {
                    break;
                }

                String toppingType = line[1];
                int toppingWeightInGrams = Integer.parseInt(line[2]);

                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
            }

            System.out.println(pizza);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}