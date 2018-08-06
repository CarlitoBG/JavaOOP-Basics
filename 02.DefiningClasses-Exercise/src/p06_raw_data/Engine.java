package p06_raw_data;

class Engine {

    private int speed;
    private int power;

    Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    int getPower() {
        return power;
    }
}