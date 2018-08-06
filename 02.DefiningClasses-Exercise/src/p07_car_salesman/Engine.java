package p07_car_salesman;

class Engine {

    private static final String DEFAULT_DISPLACEMENT = "n/a";
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private String displacement = DEFAULT_DISPLACEMENT;
    private String efficiency = DEFAULT_EFFICIENCY;

    Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    Engine(String model, int power) {
        this(model,power, DEFAULT_DISPLACEMENT,DEFAULT_EFFICIENCY);
    }

    String getModel() {
        return model;
    }

    int getPower() {
        return power;
    }

    String getDisplacement() {
        return displacement;
    }

    String getEfficiency() {
        return efficiency;
    }
}