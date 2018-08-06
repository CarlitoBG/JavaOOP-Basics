package p09_google;

public class Pokemon {

    private String name;
    private String type;

    Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.type);
    }
}