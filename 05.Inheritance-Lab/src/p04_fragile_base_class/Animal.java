package p04_fragile_base_class;

import java.util.ArrayList;

public class Animal {

    protected ArrayList<Food> foodEaten;

    public Animal(ArrayList<Food> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public final void eat(Food food){
        this.foodEaten.add(food);
    }

    public final void eatAll(Food[] foods){
        for (Food f : foods) {
            eat(f);
        }
    }
}