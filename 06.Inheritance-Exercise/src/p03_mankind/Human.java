package p03_mankind;

public class Human {

    private String firstName;
    private String lastName;

    Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))){
            throw new IllegalArgumentException(ExceptionMessages.FIRST_NAME_LETTER_ERROR);
        }
        if (firstName.length() < 4){
            throw new IllegalArgumentException(ExceptionMessages.FIRST_NAME_LENGTH_ERROR);
        }
        this.firstName = firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    protected void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))){
            throw new IllegalArgumentException(ExceptionMessages.LAST_NAME_LETTER_ERROR);
        }
        if (lastName.length() < 3){
            throw new IllegalArgumentException(ExceptionMessages.LAST_NAME_LENGTH_ERROR);
        }
        this.lastName = lastName;
    }
}