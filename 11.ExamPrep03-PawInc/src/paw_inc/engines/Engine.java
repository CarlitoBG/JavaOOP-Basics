package paw_inc.engines;

import paw_inc.core.AnimalCenterManager;
import paw_inc.io.ConsoleInputReader;
import paw_inc.utilities.InputParser;

import java.util.List;

import static paw_inc.utilities.Constants.TERMINATING_COMMAND;

public class Engine {

    private ConsoleInputReader inputReader;
    private InputParser inputParser;
    private AnimalCenterManager animalCenterManager;

    public Engine(ConsoleInputReader inputReader, InputParser inputParser, AnimalCenterManager animalCenterManager) {
        this.inputReader = inputReader;
        this.inputParser = inputParser;
        this.animalCenterManager = animalCenterManager;
    }

    public void run(){
        String inputLine;

        while (true){
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);

            if (inputLine.equals(TERMINATING_COMMAND)){
                break;
            }
        }

        this.animalCenterManager.printStatistics();
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command){
            case "RegisterCleansingCenter":
                this.animalCenterManager.registerCleansingCenter(commandParams.get(0));
                break;
            case "RegisterAdoptionCenter":
                this.animalCenterManager.registerAdoptionCenter(commandParams.get(0));
                break;
            case "RegisterDog":
                this.animalCenterManager.registerDog(commandParams.get(0), Integer.parseInt(commandParams.get(1)),
                        Integer.parseInt(commandParams.get(2)), commandParams.get(3));
                break;
            case "RegisterCat":
                this.animalCenterManager.registerCat(commandParams.get(0), Integer.parseInt(commandParams.get(1)),
                        Integer.parseInt(commandParams.get(2)), commandParams.get(3));
                break;
            case "SendForCleansing":
                this.animalCenterManager.sendForCleansing(commandParams.get(0), commandParams.get(1));
                break;
            case "Cleanse":
                this.animalCenterManager.cleanse(commandParams.get(0));
                break;
            case "Adopt":
                this.animalCenterManager.adopt(commandParams.get(0));
                break;
            case "RegisterCastrationCenter":
                this.animalCenterManager.registerCastrationCenter(commandParams.get(0));
                break;
            case "SendForCastration":
                this.animalCenterManager.sendForCastration(commandParams.get(0), commandParams.get(1));
                break;
            case "Castrate":
                this.animalCenterManager.castrate(commandParams.get(0));
                break;
            case "CastrationStatistics":
                this.animalCenterManager.castrationStatistics();
                break;
        }
    }
}