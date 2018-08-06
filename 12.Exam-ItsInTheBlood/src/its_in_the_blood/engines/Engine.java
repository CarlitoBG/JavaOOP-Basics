package its_in_the_blood.engines;

import its_in_the_blood.core.HealthManager;
import its_in_the_blood.io.ConsoleInputReader;
import its_in_the_blood.io.ConsoleOutputWriter;
import its_in_the_blood.utilities.InputParser;

import java.util.List;

import static its_in_the_blood.utilities.Constants.TERMINATING_COMMAND;

public class Engine {

    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HealthManager healthManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, HealthManager healthManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.healthManager = healthManager;
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
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command){
            case "checkCondition":
                String checkCondition = this.healthManager.checkCondition(commandParams.get(0));
                if (checkCondition != null){
                    this.outputWriter.writeLine(checkCondition);
                }
                break;
            case "createOrganism":
                String createOrganism = this.healthManager.createOrganism(commandParams.get(0));
                if (createOrganism != null){
                    this.outputWriter.writeLine(createOrganism);
                }
                break;
            case "addCluster":
                String addCluster = this.healthManager.addCluster(commandParams.get(0), commandParams.get(1),
                        Integer.parseInt(commandParams.get(2)), Integer.parseInt(commandParams.get(3)));
                if (addCluster != null){
                    this.outputWriter.writeLine(addCluster);
                }
                break;
            case "addCell":
                String addCell = this.healthManager.addCell(commandParams.get(0), commandParams.get(1), commandParams.get(2), commandParams.get(3),
                        Integer.parseInt(commandParams.get(4)), Integer.parseInt(commandParams.get(5)),
                        Integer.parseInt(commandParams.get(6)), Integer.parseInt(commandParams.get(7)));
                if (addCell != null){
                    this.outputWriter.writeLine(addCell);
                }
                break;
            case "activateCluster":
                String activateCluster = this.healthManager.activateCluster(commandParams.get(0));
                if (activateCluster != null){
                    this.outputWriter.writeLine(activateCluster);
                }
                break;
        }
    }
}