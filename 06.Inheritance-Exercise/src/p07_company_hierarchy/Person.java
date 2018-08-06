package p07_company_hierarchy;

public abstract class Person{

    private int id;
    private String firstName;
    private String lastName;

    Person(int id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setId(int id) {
        if (id < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.id = id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty() || firstName.length() < 3){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty() || lastName.length() < 3){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.lastName = lastName;
    }
}