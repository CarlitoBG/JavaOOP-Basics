package p01_vehicles;

public class Truck extends Vehicle{

    private static final double TRUCK_FUEL_CONSUMPTION = 1.6;
    private static final double TRUCK_REFUEL_RATE = 0.95;

    Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void drive(double kilometers) {
        double neededFuel = (this.getFuelConsumption() + TRUCK_FUEL_CONSUMPTION) * kilometers;
        if (neededFuel > this.getFuelQuantity()){
            throw new IllegalArgumentException(ExceptionMessages.TRUCK_MESSAGE);
        }
        this.setFuelQuantity(this.getFuelQuantity() - neededFuel);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + (liters * TRUCK_REFUEL_RATE));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}