package p06_raw_data;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    Engine getEngine() {
        return engine;
    }

    Cargo getCargo() {
        return cargo;
    }

    boolean checkTirePressure(){
        for (Tire tire : tires) {
            if (tire.getPressure() < 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}