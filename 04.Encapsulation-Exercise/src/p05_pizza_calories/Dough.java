package p05_pizza_calories;

public class Dough {
    private static final int BASE_CALORIES_PER_GRAM = 2;

    private String flourType;
    private String bakingTechnique;
    private int weightInGrams;

    Dough(String flourType, String bakingTechnique, int weightInGrams){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        switch (flourType){
            case "White":
            case "Wholegrain":
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique){
            case "White":
            case "Wholegrain":
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeightInGrams(int weightInGrams) {
        if(weightInGrams < 1 || weightInGrams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }

    public double getCalories(){
        double flourModifier = getModifier(this.flourType);
        double bakingModifier = getModifier(this.bakingTechnique);

        return (BASE_CALORIES_PER_GRAM * this.weightInGrams) * bakingModifier * flourModifier;
    }

    private double getModifier(String modifier) {
        switch (modifier){
            case "White":
                return 1.5;
            case "Wholegrain":
            case "Homemade":
                return 1.0;
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
        }
        return -1;
    }
}