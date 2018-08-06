package p03_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String studentInfo = reader.readLine();
        String workerInfo = reader.readLine();

        String[] studentTokens = studentInfo.split("\\s+");
        String studentFirstName = studentTokens[0];
        String studentLastName = studentTokens[1];
        String facultyNumber = studentTokens[2];

        String[] workerTokens = workerInfo.split("\\s+");
        String workerFirstName = workerTokens[0];
        String workerLastName = workerTokens[1];
        double salary = Double.parseDouble(workerTokens[2]);
        double workingHours = Double.parseDouble(workerTokens[3]);

        try {
            Student student = new Student(studentFirstName, studentLastName, facultyNumber);
            Worker worker = new Worker(workerFirstName, workerLastName, salary, workingHours);

            System.out.println(student.toString());
            System.out.println(worker.toString());
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}