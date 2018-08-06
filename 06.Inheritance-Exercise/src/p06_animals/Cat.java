package p06_animals;

class Cat extends Animal{

    Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    String produceSound() {
        return Messages.CAT_SOUND;
    }
}