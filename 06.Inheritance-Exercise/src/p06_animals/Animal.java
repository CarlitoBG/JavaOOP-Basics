package p06_animals;

class Animal {

    private String name;
    private int age;
    private String gender;

    Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty() || (!gender.equals(Messages.TOMCAT_GENDER) && !gender.equals(Messages.KITTEN_GENDER))){
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        this.gender = gender;
    }

    String produceSound(){
        return Messages.ANIMAL_SOUND;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(), this.name, this.age, this.gender, this.produceSound());
    }
}