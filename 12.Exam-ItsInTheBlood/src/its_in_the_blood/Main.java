package its_in_the_blood;

import its_in_the_blood.core.HealthManager;
import its_in_the_blood.engines.Engine;
import its_in_the_blood.io.ConsoleInputReader;
import its_in_the_blood.io.ConsoleOutputWriter;
import its_in_the_blood.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        HealthManager healthManager = new HealthManager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, healthManager);

        engine.run();
    }
}