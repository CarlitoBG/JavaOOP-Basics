package p03_animal_farm;

public class Chicken {

    private String name;
    private int age;

    Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private String productPerDay() {
        if (this.getAge() <= 5){
            return "2";
        }else if (this.getAge() >= 6 && this.getAge() <= 11){
            return "1";
        }else {
            return "0.75";
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Chicken %s (age %d) can produce %s eggs per day.", this.getName(), this.getAge(), productPerDay());
    }
}