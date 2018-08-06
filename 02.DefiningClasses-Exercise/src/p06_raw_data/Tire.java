package p06_raw_data;

class Tire {

    private int tireAge;
    private double pressure;

    Tire(int tireAge, double pressure) {
        this.tireAge = tireAge;
        this.pressure = pressure;
    }

    double getPressure() {
        return pressure;
    }
}