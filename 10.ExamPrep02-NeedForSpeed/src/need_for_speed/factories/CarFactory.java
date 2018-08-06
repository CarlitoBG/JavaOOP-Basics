package need_for_speed.factories;

import need_for_speed.entities.cars.Car;
import need_for_speed.entities.cars.PerformanceCar;
import need_for_speed.entities.cars.ShowCar;

public final class CarFactory {

    public CarFactory() {}

    public static Car createShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration,
                                    int suspension, int durability){
        return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public static Car createPerformanceCar(String brand, String model, int yearOfProduction, int horsepower,
                                           int acceleration, int suspension, int durability){
        return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }
}