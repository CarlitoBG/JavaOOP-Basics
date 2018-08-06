package p09_google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        String line = reader.readLine();
        while (true){
            if ("End".equals(line)){
                break;
            }

            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String personInfo = tokens[1];

            people.putIfAbsent(name, new Person(name));

            switch (personInfo){
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String type = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    people.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    people.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Children child = new Children(childName, childBirthday);
                    people.get(name).getChildren().add(child);
                    break;
                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(model, speed);
                    people.get(name).setCar(car);
                    break;
            }

            line = reader.readLine();
        }

        String soughtName = reader.readLine();

        for (Person person : people.values()) {
            if (person.getName().equals(soughtName)){
                System.out.println(person);
            }
        }
    }
}