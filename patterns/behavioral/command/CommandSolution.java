package patterns.behavioral.command;

public class CommandSolution {

    public static void main(String[] args){
        var carEngine = new CarEngine();
        var startEngine = new StartEngineCommand(carEngine);
        var stopEngine = new StopEngineCommand(carEngine);

        var switcher = new CommandSwitcher();

        switcher.pressButton();

        switcher.setCarEngineCommand(startEngine);
        switcher.pressButton();

        switcher.setCarEngineCommand(stopEngine);
        switcher.pressButton();
    }

}