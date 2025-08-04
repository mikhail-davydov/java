package patterns.behavioral.command;

public class CommandSwitcher {

    private CarEngineCommand carEngineCommand;

    public void setCarEngineCommand(CarEngineCommand carEngineCommand) {
        System.out.println("Set command: " + carEngineCommand.getCommandType());
        this.carEngineCommand = carEngineCommand;
    }

    public void pressButton() {
        if (null == carEngineCommand) {
            System.out.println("Unsupported operation. No command set");
            return;
        }
        System.out.print("Press button: ");
        carEngineCommand.execute();
    }

}