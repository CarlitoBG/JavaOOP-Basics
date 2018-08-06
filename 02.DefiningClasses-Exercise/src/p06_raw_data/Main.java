package p06_raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new LinkedList<>();
        int numberOfCars = Integer.parseInt(reader.readLine());

        while (numberOfCars-- > 0){
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Age, tire1Pressure);
            Tire tire2 = new Tire(tire2Age, tire2Pressure);
            Tire tire3 = new Tire(tire3Age, tire3Pressure);
            Tire tire4 = new Tire(tire4Age, tire4Pressure);
            Tire[] tires = {tire1, tire2, tire3, tire4};

            Car car = new Car(model, engine, cargo, tires);

            cars.add(car);
        }

        String command = reader.readLine();

        switch (command){
            case "fragile":
                cars.stream()
                        .filter(car -> car.getCargo().getType().equals("fragile"))
                        .filter(Car::checkTirePressure)
                        .forEach(System.out::println);
                break;
            case "flamable":
                cars.stream()
                        .filter(car -> car.getCargo().getType().equals("flamable"))
                        .filter(car -> car.getEngine().getPower() > 250)
                        .forEach(System.out::println);
                break;
        }
    }
}