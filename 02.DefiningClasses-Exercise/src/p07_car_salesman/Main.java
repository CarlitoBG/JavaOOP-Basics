package p07_car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Engine> engines = new LinkedList<>();
        LinkedList<Car> cars = new LinkedList<>();

        int numberOfEngines = Integer.parseInt(reader.readLine());
        getEngine(reader, engines, numberOfEngines);

        int numberOfCars = Integer.parseInt(reader.readLine());
        getCar(reader, engines, cars, numberOfCars);

        cars.forEach(System.out::println);
    }

    private static void getEngine(BufferedReader reader, LinkedList<Engine> engines, int numberOfEngines) throws IOException {

        while (numberOfEngines-- > 0){
            String[] engineTokens = reader.readLine().split("\\s+");
            String model = engineTokens[0];
            int power = Integer.parseInt(engineTokens[1]);

            Engine engine = null;
            switch (engineTokens.length){
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    if (engineTokens[2].matches("\\d+")){
                        String displacement = engineTokens[2];
                        engine = new Engine(model, power, displacement, "n/a");
                    }else {
                        String efficiency = engineTokens[2];
                        engine = new Engine(model, power, "n/a", efficiency);
                    }
                    break;
                case 4:
                    String displacement = engineTokens[2];
                    String efficiency = engineTokens[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }

            engines.add(engine);
        }
    }

    private static void getCar(BufferedReader reader, LinkedList<Engine> engines, LinkedList<Car> cars, int numberOfCars) throws IOException {

        while (numberOfCars-- > 0){
            String [] carTokens = reader.readLine().split("\\s+");
            String model = carTokens[0];

            Engine realEngine = null;
            for (Engine engine : engines) {
                if (engine.getModel().equals(carTokens[1])){
                    realEngine = engine;
                    break;
                }
            }

            Car car = null;
            switch (carTokens.length){
                case 2:
                    car = new Car(model, realEngine);
                    break;
                case 3:
                    if (carTokens[2].matches("\\d+")){
                        String weight = carTokens[2];
                        car = new Car(model, realEngine, weight, "n/a");
                    }else {
                        String color = carTokens[2];
                        car = new Car(model, realEngine, "n/a", color);
                    }
                    break;
                case 4:
                    String weight = carTokens[2];
                    String color = carTokens[3];
                    car = new Car(model, realEngine, weight, color);
                    break;
            }

            cars.add(car);
        }
    }
}