package p09_google;

public class Company {

    private String name;
    private String department;
    private double salary;

    Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.name, this.department, this.salary);
    }
}