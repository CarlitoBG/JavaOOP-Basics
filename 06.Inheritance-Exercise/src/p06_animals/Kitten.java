package p06_animals;

public class Kitten extends Cat{

    Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equals(Messages.KITTEN_GENDER)){
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        super.setGender(gender);
    }

    @Override
    String produceSound() {
        return Messages.KITTEN_SOUND;
    }
}