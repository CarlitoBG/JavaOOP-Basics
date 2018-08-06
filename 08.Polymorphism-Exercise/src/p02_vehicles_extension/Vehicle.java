package p02_vehicles_extension;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    double getFuelQuantity() {
        return this.fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    double getFuelConsumption() {
        return this.fuelConsumption;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    double getTankCapacity() {
        return this.tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void driveWithConditioner(double kilometers){}

    public abstract void drive(double kilometers);

    public abstract void refuel(double liters);
}