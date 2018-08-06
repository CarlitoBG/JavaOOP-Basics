package p03_opinion_poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            String[] personalInfo = reader.readLine().split("\\s+");

            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);

            persons[i] = new Person(name, age);
        }

        Arrays.stream(persons)
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}