package p02_vehicles_extension;

public class Bus extends Vehicle{

    private static final double FULL_BUS_CONSUMPTION = 1.4;

    Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double kilometers) {
        double neededFuel = this.getFuelConsumption() * kilometers;
        if (neededFuel > this.getFuelQuantity()){
            throw new IllegalArgumentException(ExceptionMessages.BUS_MESSAGE);
        }
        super.setFuelQuantity(this.getFuelQuantity() - neededFuel);
    }

    @Override
    public void driveWithConditioner(double kilometers) {
        double neededFuel = (this.getFuelConsumption() + FULL_BUS_CONSUMPTION) * kilometers;
        if (neededFuel > this.getFuelQuantity()){
            throw new IllegalArgumentException(ExceptionMessages.BUS_MESSAGE);
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
        super.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}