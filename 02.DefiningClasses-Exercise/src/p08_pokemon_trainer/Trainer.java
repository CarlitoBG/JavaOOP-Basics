package p08_pokemon_trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private static final int DEFAULT_BADGES = 0;

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    Trainer(String name) {
        this.name = name;
        this.numberOfBadges = DEFAULT_BADGES;
        this.pokemons = new ArrayList<>();
    }

    int getNumberOfBadges() {
        return numberOfBadges;
    }

    void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}