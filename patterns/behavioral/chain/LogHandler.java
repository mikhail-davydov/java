package patterns.behavioral.chain;

public class LogHandler extends ActionHandler {

    public LogHandler() {
        super();
    }

    public LogHandler(ActionHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected boolean canHandle(Action action) {
        return action.type() == ActionType.LOG || action.type() == ActionType.ALL;
    }

    @Override
    protected void processRequest(Action action) {
        System.out.println("Handle log action for " + action.name());
    }

}
