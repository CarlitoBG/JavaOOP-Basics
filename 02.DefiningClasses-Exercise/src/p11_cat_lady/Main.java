package p11_cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, BaseCat> cats = new HashMap<>();

        String line = reader.readLine();
        while (true){
            if ("End".equals(line)){
                break;
            }

            String[] tokens = line.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double characteristic = Double.parseDouble(tokens[2]);

            BaseCat cat = null;
            switch (breed){
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, breed, characteristic);
                    break;
                case "Siamese":
                    cat = new Siamese(name, breed, characteristic);
                    break;
                case "Cymric":
                    cat = new Cymric(name, breed, characteristic);
                    break;
            }

            cats.putIfAbsent(name, cat);

            line = reader.readLine();
        }

        System.out.println(cats.get(reader.readLine()));
    }
}