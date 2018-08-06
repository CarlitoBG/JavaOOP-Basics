package p04_company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();

        int countOfEmployees = Integer.parseInt(reader.readLine());

        while (countOfEmployees-- > 0){
            String[] tokens = reader.readLine().split("\\s+");

            Employee employee = null;
            switch (tokens.length){
                case 4:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3]);
                    break;
                case 5:
                    if (tokens[4].contains("@")){
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4]);
                    }else {
                        employee = new Employee(tokens[0], Double.parseDouble(
                                tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]));
                    }
                    break;
                case 6:
                    employee = new Employee(tokens[0], Double.parseDouble(
                            tokens[1]), tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]));
                    break;
            }

            String department = employee.getDepartment();
            if (!employeesByDepartment.containsKey(department)){
                employeesByDepartment.putIfAbsent(department, new ArrayList<>());
            }
            employeesByDepartment.get(department).add(employee);
        }

        employeesByDepartment.entrySet()
                .stream()
                .sorted((d1, d2) -> Double.compare(
                        d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder sb = new StringBuilder(String.format("Highest Average Salary: %s%n", d.getKey()));
                    d.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .forEach(employee -> sb.append(employee).append(System.lineSeparator()));

                    System.out.println(sb.toString());
                });
    }
}