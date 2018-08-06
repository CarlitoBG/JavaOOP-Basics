package p10_family_tree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getBirthDate() {
        return birthDate;
    }

    List<Person> getChildren() {
        return children;
    }

    List<Person> getParents() {
        return parents;
    }

    private String personalInfo(){
        return String.format("%s %s", this.name, this.birthDate);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.personalInfo()).append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        for (Person parent : this.parents) {
            sb.append(parent.personalInfo()).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (Person child : children) {
            sb.append(child.personalInfo()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}