package p04_shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] allPeople = reader.readLine().split("[;=]");
        String[] allProducts = reader.readLine().split("[;=]");

        try {
            for (int i = 0; i < allPeople.length; i+=2) {
                Person person = new Person(allPeople[i], Double.parseDouble(allPeople[i + 1]));
                persons.putIfAbsent(person.getName(), person);
            }

            for (int i = 0; i < allProducts.length; i+=2) {
                Product product = new Product(allProducts[i], Double.parseDouble(allProducts[i + 1]));
                products.putIfAbsent(product.getName(), product);
            }

            String command;
            while (true){
                if ("END".equals(command = reader.readLine())) {
                    break;
                }

                String[] tokens = command.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];

                if (persons.containsKey(personName) && products.containsKey(productName)){
                    Person person = persons.get(personName);
                    Product product = products.get(productName);

                    if (person.hasEnoughMoney(product.getCost())){
                        person.buyProduct(product);
                        System.out.printf("%s bought %s%n", person.getName(), product.getName());
                    }else {
                        System.out.printf("%s can't afford %s%n", person.getName(), product.getName());
                    }
                }
            }

            persons.values().forEach(System.out::println);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}