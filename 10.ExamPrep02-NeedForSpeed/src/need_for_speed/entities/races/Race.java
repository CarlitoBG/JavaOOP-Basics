package need_for_speed.entities.races;

import need_for_speed.entities.cars.Car;

import java.util.*;

public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.participants.add(car);
    }

    int getLength() {
        return this.length;
    }

    int getPrizePool() {
        return this.prizePool;
    }

    String getRoute() {
        return this.route;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    protected abstract int calculatePoints(Car car);

    private Map<Integer, Car> getWinners() {
        Map<Integer, Car> winners = new HashMap<>();
        final int[] position = {1};

        this.participants.stream()
                .sorted((c1, c2) -> Integer.compare(this.calculatePoints(c2), this.calculatePoints(c1)))
                .limit(3)
                .forEach(car -> winners.putIfAbsent(position[0]++, car));

        return winners;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - %d", this.route, this.length)).append(System.lineSeparator());
        for (Map.Entry<Integer, Car> carEntry : this.getWinners().entrySet()) {
            int position = carEntry.getKey();
            Car car = carEntry.getValue();
            int prize = getPrize(position);

            sb.append(String.format("%d. %s %s %dPP - $%d", position, car.getBrand(), car.getModel(), this.calculatePoints(car), prize))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    private int getPrize(int position) {
        switch (position) {
            case 1:
                return (this.prizePool * 50) / 100;
            case 2:
                return (this.prizePool * 30) / 100;
            case 3:
                return (this.prizePool * 20) / 100;
            default:
                return 0;
        }
    }
}