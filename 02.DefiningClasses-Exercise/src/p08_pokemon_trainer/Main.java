package p08_pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int DEFAULT_BADGE_GAIN = 1;
    private static final int DEFAULT_HEALTH_LOSS = 10;
    private static final int DEFAULT_CRITICAL_HEALTH = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        getPokemonByTrainer(reader, trainers);
        checkTrainerForPokemon(reader, trainers);

        trainers.values()
                .stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }

    private static void getPokemonByTrainer(BufferedReader reader, Map<String, Trainer> trainers) throws IOException {

        String line = reader.readLine();
        while (true){
            if ("Tournament".equals(line)){
                break;
            }

            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemons().add(new Pokemon(pokemonName,pokemonElement, pokemonHealth));

            line = reader.readLine();
        }
    }

    private static void checkTrainerForPokemon(BufferedReader reader, Map<String, Trainer> trainers) throws IOException {

        String line = reader.readLine();
        while (true){
            if ("End".equals(line)){
                break;
            }

            for (Trainer trainer : trainers.values()) {
                boolean elementFound = false;
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getElement().equals(line)){
                        elementFound = true;
                        break;
                    }
                }

                if (elementFound){
                    trainer.setNumberOfBadges(trainer.getNumberOfBadges() + DEFAULT_BADGE_GAIN);
                }else{
                    for (Pokemon pokemon : trainer.getPokemons()) {
                        pokemon.setHealth(pokemon.getHealth() - DEFAULT_HEALTH_LOSS);
                        if (pokemon.getHealth() <= DEFAULT_CRITICAL_HEALTH){
                            trainer.getPokemons().remove(pokemon);
                            break;
                        }
                    }
                }
            }

            line = reader.readLine();
        }
    }
}