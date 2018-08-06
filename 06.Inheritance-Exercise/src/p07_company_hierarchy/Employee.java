package p07_company_hierarchy;

public abstract class Employee extends Person{

    private double salary;
    private DepartmentType departmentType;

    Employee(int id, String firstName, String lastName, double salary, DepartmentType departmentType) {
        super(id, firstName, lastName);
        this.setSalary(salary);
        this.departmentType = departmentType;
    }

    Employee(int id, String firstName, String lastName, DepartmentType department) {
        super(id, firstName, lastName);
        this.setSalary(0.0);
        this.departmentType = department;
    }

    Employee(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.setSalary(0.0);
    }

    public DepartmentType getDepartmentType() {
        return this.departmentType;
    }

    private void setSalary(double salary) {
        if (salary < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.salary = salary;
    }
}