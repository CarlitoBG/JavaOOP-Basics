package p05_pizza_calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int toppings){
        if(toppings < 0 || toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough){
        this.dough = dough;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    private double getCalories(){
        double doughCalories = this.dough.getCalories();
        double toppingCalories = 0.0;

        for (Topping topping : this.toppings) {
            toppingCalories += topping.getCalories();
        }
        return doughCalories + toppingCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getCalories());
    }
}