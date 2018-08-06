package p06_animals;

class Dog extends Animal{

    Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    String produceSound() {
        return Messages.DOG_SOUND;
    }
}