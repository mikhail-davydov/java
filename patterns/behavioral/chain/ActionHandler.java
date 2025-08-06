package patterns.behavioral.chain;

public abstract class ActionHandler {

    private ActionHandler nextHandler;

    protected ActionHandler() {
        this.nextHandler = null;
    }

    protected ActionHandler(ActionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void setNextHandler(ActionHandler handler) {
        this.nextHandler = handler;
    }

    public final void handleAction(Action action) {
        if (canHandle(action)) {
            processRequest(action);
            action.setHandled(true);
        }

        if (nextHandler != null) {
            nextHandler.handleAction(action);
            action.setHandled(true);
        }

        if (!action.handled()) {
            System.out.println("No suitable handler found");
        }
    }

    protected abstract boolean canHandle(Action action);
    protected abstract void processRequest(Action action);

}