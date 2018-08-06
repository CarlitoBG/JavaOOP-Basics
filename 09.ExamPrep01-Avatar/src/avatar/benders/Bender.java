package avatar.benders;

public abstract class Bender {

    private String name;
    private int power;

    Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public abstract double getTotalPower();
}