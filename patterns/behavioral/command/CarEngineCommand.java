package patterns.behavioral.command;

public interface CarEngineCommand {

    CommandType getCommandType();

    void execute();

}