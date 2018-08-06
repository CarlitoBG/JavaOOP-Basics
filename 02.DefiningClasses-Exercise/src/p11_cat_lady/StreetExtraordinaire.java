package p11_cat_lady;

public class StreetExtraordinaire extends BaseCat{

    private double decibelsOfMeows;

    StreetExtraordinaire(String name, String type, double decibelsOfMeows) {
        super(name, type);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.decibelsOfMeows);
    }
}