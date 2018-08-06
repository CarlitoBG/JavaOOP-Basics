package paw_inc;

import paw_inc.core.AnimalCenterManager;
import paw_inc.engines.Engine;
import paw_inc.io.ConsoleInputReader;
import paw_inc.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        InputParser inputParser = new InputParser();
        AnimalCenterManager carManager = new AnimalCenterManager();
        Engine engine = new Engine(inputReader, inputParser, carManager);

        engine.run();
    }
}