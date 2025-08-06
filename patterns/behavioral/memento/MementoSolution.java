package patterns.behavioral.memento;

public class MementoSolution {

    public static void main(String[] args) {

        var carStateHistory = new CarStateHistory();
        var car = new Car("carcase");
        car.printCurrentState();
        var initialState = car.save(carStateHistory);

        car.addState("tyres");
        car.printCurrentState();
        car.save(carStateHistory);

        car.addState("doors");
        car.printCurrentState();
        car.save(carStateHistory);

        car.addState("driving wheel");
        car.printCurrentState();
        car.save(carStateHistory);

        System.out.println("\nOoops! Something went wrong, undo the operation\n");

        car.undo(carStateHistory);
        car.printCurrentState();

        System.out.println("\nAnd once again\n");

        car.undo(carStateHistory);
        car.printCurrentState();

        System.out.println("\nWait, the previous state was right, redo the operation\n");

        car.redo(carStateHistory);
        car.printCurrentState();

        System.out.println("\nTo the initial state\n");
        car.restore(initialState);
        car.printCurrentState();

        try {
            car.undo(carStateHistory);
        } catch (Exception e) {
            System.out.println("\nHandle exception: " + e.getMessage());
        }

    }

}