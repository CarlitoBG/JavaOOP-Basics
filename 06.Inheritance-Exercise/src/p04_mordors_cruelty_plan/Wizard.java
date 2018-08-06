package p04_mordors_cruelty_plan;

import java.util.List;

public class Wizard {

    private int happiness;

    Wizard() {
        this.happiness = 0;
    }

    public void eatAll(List<Food> foods){
        for (Food food : foods) {
            this.happiness += food.getHappiness();
        }
    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.happiness, Mood.getMood(this.happiness));
    }
}