package p07_company_hierarchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager extends Employee{

    private List<Employee> employees;

    public Manager(int id, String firstName, String lastName, double salary, DepartmentType departmentType) {
        super(id, firstName, lastName, salary, departmentType);
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void addEmployee(Employee employee){
        if (employee == null){
            throw new NullPointerException("Employee cannot be null");
        }

        if (employee.getDepartmentType() != this.getDepartmentType()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.employees.add(employee);
    }
}