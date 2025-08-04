package patterns.behavioral.command;

public class StopEngineCommand implements CarEngineCommand {

    private final CarEngine carEngine;

    public StopEngineCommand(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.STOP_ENGINE;
    }

    @Override
    public void execute() {
        carEngine.stop();
    }

}