package p02_vehicles_extension;

public class Truck extends Vehicle{

    private static final double TRUCK_FUEL_CONSUMPTION = 1.6;
    private static final double TRUCK_REFUEL_RATE = 0.95;

    Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double kilometers) {
        double neededFuel = (this.getFuelConsumption() + TRUCK_FUEL_CONSUMPTION) * kilometers;
        if (neededFuel > this.getFuelQuantity()){
            throw new IllegalArgumentException(ExceptionMessages.TRUCK_MESSAGE);
        }
        super.setFuelQuantity(this.getFuelQuantity() - neededFuel);
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0){
            throw new IllegalArgumentException(ExceptionMessages.FUEL_QUANTITY_MESSAGE);
        }
        if ((super.getFuelQuantity() + liters) > super.getTankCapacity()){
            throw new IllegalArgumentException(ExceptionMessages.TANK_CAPACITY_MESSAGE);
        }
        super.setFuelQuantity(this.getFuelQuantity() + (liters * TRUCK_REFUEL_RATE));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}