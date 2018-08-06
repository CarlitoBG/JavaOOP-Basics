package p07_company_hierarchy;

public class RegularEmployee extends Employee{

    public RegularEmployee(int id, String firstName, String lastName, double salary, DepartmentType departmentType) {
        super(id, firstName, lastName, salary, departmentType);
    }
}