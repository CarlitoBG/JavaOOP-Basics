package need_for_speed.core;

import need_for_speed.entities.cars.Car;
import need_for_speed.entities.garage.Garage;
import need_for_speed.entities.races.Race;
import need_for_speed.factories.CarFactory;
import need_for_speed.factories.RaceFactory;

import java.util.HashMap;
import java.util.Map;

import static need_for_speed.utilities.Constants.*;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability) {
        Car car = null;
        switch (type) {
            case PERFORMANCE_CAR_TYPE:
                car = CarFactory.createPerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case SHOW_CAR_TYPE:
                car = CarFactory.createShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }
        this.cars.put(id, car);
    }

    public String check(int id) {
        if (this.cars.containsKey(id)) {
            return this.cars.get(id).toString();
        }
        return null;
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case CASUAL_RACE_TYPE:
                race = RaceFactory.createCasualRace(length, route, prizePool);
                break;
            case DRIFT_RACE_TYPE:
                race = RaceFactory.createDriftRace(length, route, prizePool);
                break;
            case DRAG_RACE_TYPE:
                race = RaceFactory.createDragRace(length, route, prizePool);
                break;
        }
        this.races.putIfAbsent(id, race);
    }

    public void open(int id, String type, int length, String route, int prizePool, int optionalParam) {
        Race race = null;
        switch (type) {
            case CASUAL_RACE_TYPE:
                race = RaceFactory.createCasualRace(length, route, prizePool);
                break;
            case DRIFT_RACE_TYPE:
                race = RaceFactory.createDriftRace(length, route, prizePool);
                break;
            case DRAG_RACE_TYPE:
                race = RaceFactory.createDragRace(length, route, prizePool);
                break;
            case TIME_LIMIT_RACE_TYPE:
                race = RaceFactory.createTimeLimitRace(length, route, prizePool, optionalParam);
                break;
            case CIRCUIT_RACE_TYPE:
                race = RaceFactory.createCircuitRace(length, route, prizePool, optionalParam);
                break;
        }
        this.races.putIfAbsent(id, race);
    }

    public void participate(int carId, int raceId) {
        if(this.cars.containsKey(carId) && this.races.containsKey(raceId) && !this.garage.getParkedCars().contains(this.cars.get(carId))){
            Race race = this.races.get(raceId);
            Car car = this.cars.get(carId);
            race.addCar(car);
        }
    }

    public String start(int id) {
        if (this.races.containsKey(id) && this.races.get(id).getParticipants().size() != 0){
            return this.races.remove(id).toString();
        }
        return CANNOT_START_RACE;
    }

    public void park(int id) {
        if (this.cars.containsKey(id)){
            Car car = this.cars.get(id);
            long countOfRaces = this.races.values().stream().filter(r -> r.getParticipants().contains(car)).count();

            if (countOfRaces == 0){
                this.garage.park(car);
            }
        }
    }

    public void unpark(int id) {
        if (this.cars.containsKey(id) && this.garage.getParkedCars().contains(this.cars.get(id))){
            this.garage.unpark(this.cars.get(id));
        }
    }

    public void tune(int tuneIndex, String addOn) {
        if (this.garage.getParkedCars().size() != 0){
            this.garage.tune(tuneIndex, addOn);
        }
    }
}