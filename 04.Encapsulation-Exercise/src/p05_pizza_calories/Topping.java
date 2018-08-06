package p05_pizza_calories;

public class Topping {
    private static final int BASE_CALORIES_PER_GRAM = 2;

    private String type;
    private int weight;

    Topping(String type, int weight) {
        setType(type);
        setWeight(weight);
    }

    private void setType(String type) {
        switch (type) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.type = type;
                break;
            default:
                throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
        }
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.type + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double getCalories(){
        double modifier = getModifier(this.type);
        return this.weight * modifier * BASE_CALORIES_PER_GRAM;
    }

    private double getModifier(String type){
        switch (type){
            case"Meat":
                return 1.2;
            case"Veggies":
                return 0.8;
            case"Cheese":
                return 1.1;
            case"Sauce":
                return 0.9;
        }
        return -1;
    }
}