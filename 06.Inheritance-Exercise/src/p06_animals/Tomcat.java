package p06_animals;

public class Tomcat extends Cat{

    Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equals(Messages.TOMCAT_GENDER)) {
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        super.setGender(gender);
    }

    @Override
    String produceSound() {
        return Messages.TOMCAT_SOUND;
    }
}