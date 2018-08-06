package p10_family_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();
        List<String> connections = new ArrayList<>();

        String personToFind = reader.readLine();

        String line = reader.readLine();
        while (true){
            if ("End".equals(line)){
                break;
            }

            if (!line.contains("-")){
                int splitIndex = line.lastIndexOf(" ");
                String name = line.substring(0, splitIndex);
                String birthDate = line.substring(splitIndex + 1);

                Person person = new Person(name, birthDate);
                people.put(name, person);
            }else {
                connections.add(line);
            }

            line = reader.readLine();
        }

        for (String connection : connections) {
            String[] connectionTokens = connection.split(" - ");
            String parentInfo = connectionTokens[0];
            String childInfo = connectionTokens[1];

            Person parent = definePersonByInfoType(parentInfo, people);
            Person child = definePersonByInfoType(childInfo, people);

            if (parent != null && child != null){
                parent.getChildren().add(child);
                child.getParents().add(parent);
            }
        }

        System.out.print(definePersonByInfoType(personToFind, people).toString());
    }

    private static Person definePersonByInfoType(String personInfo, Map<String, Person> people) {
        if (personInfo.contains("/")){
            for (Person person : people.values()) {
                if (personInfo.equals(person.getBirthDate())){
                    return person;
                }
            }
        }
        return people.get(personInfo);
    }
}