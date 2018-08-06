package p06_animals;

class Frog extends Animal{

    Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    String produceSound() {
        return Messages.FROG_SOUND;
    }
}