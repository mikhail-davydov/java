package patterns.behavioral.command;

public class StartEngineCommand implements CarEngineCommand {

    private final CarEngine carEngine;

    public StartEngineCommand(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.START_ENGINE;
    }

    @Override
    public void execute() {
        carEngine.start();
    }

}