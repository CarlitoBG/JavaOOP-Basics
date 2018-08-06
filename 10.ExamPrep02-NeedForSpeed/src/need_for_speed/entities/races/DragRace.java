package need_for_speed.entities.races;

import need_for_speed.entities.cars.Car;

import java.util.List;

public class DragRace extends Race{

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePoints(Car car) {
        return car.getHorsepower() / car.getAcceleration();
    }
}