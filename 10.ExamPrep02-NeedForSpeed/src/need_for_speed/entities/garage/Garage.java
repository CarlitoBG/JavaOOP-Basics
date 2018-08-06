package need_for_speed.entities.garage;

import need_for_speed.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {

    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    public void park(Car car){
        this.parkedCars.add(car);
    }

    public void  unpark(Car car){
        this.parkedCars.remove(car);
    }

    public void tune(int tuneIndex, String addOn){
        this.parkedCars.forEach(car -> car.tuneCar(tuneIndex, addOn));
    }
}