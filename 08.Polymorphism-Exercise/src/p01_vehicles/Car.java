package p01_vehicles;

public class Car extends Vehicle{

    private static final double CAR_FUEL_CONSUMPTION = 0.9;

    Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void drive(double kilometers) {
        double neededFuel = (this.getFuelConsumption() + CAR_FUEL_CONSUMPTION) * kilometers;
        if (neededFuel > this.getFuelQuantity()){
            throw new IllegalArgumentException(ExceptionMessages.CAR_MESSAGE);
        }
        this.setFuelQuantity(this.getFuelQuantity() - neededFuel);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}