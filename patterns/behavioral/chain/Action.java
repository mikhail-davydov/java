package patterns.behavioral.chain;

public final class Action {
    private final String name;
    private final ActionType type;
    private boolean handled = false;

    public Action(String name, ActionType type) {
        this.name = name;
        this.type = type;
    }

    public String name() {
        return name;
    }

    public ActionType type() {
        return type;
    }

    public boolean handled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

}
