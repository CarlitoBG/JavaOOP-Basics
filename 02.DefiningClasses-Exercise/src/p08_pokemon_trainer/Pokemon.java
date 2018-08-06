package p08_pokemon_trainer;

public class Pokemon {

    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    String getElement() {
        return element;
    }

    int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }
}