package patterns.behavioral.chain;

import java.util.List;

public class ChainSolution {

    public static void main(String[] args) {
        var chain = new AuthHandler(new LogHandler());

        var actions = List.of(
                new Action("authAction", ActionType.AUTH),
                new Action("logAction", ActionType.LOG),
                new Action("allAction", ActionType.ALL),
                new Action("noneAction", ActionType.NONE)
        );
        actions.forEach(action -> handleAction(action, chain));
    }

    private static void handleAction(Action action, ActionHandler chain) {
        System.out.println("\nStart processing " + action.name() + " with type " + action.type());
        chain.handleAction(action);
        System.out.println("Stop processing " + action.name() + " with type " + action.type());
    }

}