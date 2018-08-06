package p05_speed_racing;

public class Car {
    private static final int DEFAULT_DISTANCE_TRAVELED = 0;

    private String model;
    private double fuel;
    private double costPerKilometer;
    private int distanceTraveled;

    Car(String model, double fuel, double costPerKilometer) {
        this.model = model;
        this.fuel = fuel;
        this.costPerKilometer = costPerKilometer;
        this.distanceTraveled = DEFAULT_DISTANCE_TRAVELED;
    }

    void drive(int kilometers) {
        double fuelForDrive = kilometers * this.costPerKilometer;
        if (fuelForDrive > this.fuel){
            throw new IllegalStateException("Insufficient fuel for the drive");
        }

        this.distanceTraveled += kilometers;
        this.fuel -= fuelForDrive;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }
}