package p04_fragile_base_class;

public class Main {
    public static void main(String[] args) {

        Predator predator = new Predator();
        predator.eat(new Food());
        System.out.println(predator.getHealth());
        predator.eatAll(new Food[]{new Food(), new Food()});
        System.out.println(predator.getHealth());
    }
}