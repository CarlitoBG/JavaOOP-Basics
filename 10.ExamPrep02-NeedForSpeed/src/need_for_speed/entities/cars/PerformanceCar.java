package need_for_speed.entities.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        int increasedHorsepower = horsepower + ((horsepower * 50) / 100);
        super.setHorsepower(increasedHorsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        int decreasedSuspension = suspension - ((suspension * 25) / 100);
        super.setSuspension(decreasedSuspension);
    }

    @Override
    public void tuneCar(int tuneIndex, String addOn) {
        this.addOns.add(addOn);
        super.tuneCar(tuneIndex, addOn);
    }

    @Override
    public String toString() {
        return String.format("%sAdd-ons: %s", super.toString(), this.addOns.size() > 0 ? String.join(", ", this.addOns) : "None");
    }
}