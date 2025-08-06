package patterns.behavioral.chain;

public class AuthHandler extends ActionHandler {

    public AuthHandler() {
        super();
    }

    public AuthHandler(LogHandler logHandler) {
        super(logHandler);
    }

    @Override
    protected boolean canHandle(Action action) {
        return action.type() == ActionType.AUTH || action.type() == ActionType.ALL;
    }

    @Override
    protected void processRequest(Action action) {
        System.out.println("Handle auth action for " + action.name());
    }

}
