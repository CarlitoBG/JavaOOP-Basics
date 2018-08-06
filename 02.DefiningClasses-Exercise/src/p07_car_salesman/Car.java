package p07_car_salesman;

public class Car {

    private static final String DEFAULT_COLOR = "n/a";
    private static final String DEFAULT_WEIGHT = "n/a";

    private String model;
    private Engine engine;
    private String weight = DEFAULT_WEIGHT;
    private String color = DEFAULT_COLOR;

    Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    Car(String model, Engine engine) {
        this(model,engine, DEFAULT_WEIGHT, DEFAULT_COLOR);
    }

    private Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return String.format(
                "%s:%n  %s:%n   Power: %s%n   Displacement: %s%n   Efficiency: %s%n  Weight: %s%n  Color: %s",
                this.model, this.getEngine().getModel(), this.getEngine().getPower(), this.getEngine().getDisplacement(),
                this.getEngine().getEfficiency(), this.weight, this.color);
    }
}