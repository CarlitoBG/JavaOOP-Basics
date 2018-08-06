package p07_company_hierarchy;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee {

    private List<Project> projects;

    Developer(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return this.projects;
    }
}