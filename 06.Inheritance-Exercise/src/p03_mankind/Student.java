package p03_mankind;

public class Student extends Human{

    private String facultyNumber;

    Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalArgumentException(ExceptionMessages.FACULTY_NUMBER_ERROR);
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return String.format("First name: %s%nLast Name: %s%nFaculty Number: %s",
                super.getFirstName(), super.getLastName(), this.facultyNumber);
    }
}