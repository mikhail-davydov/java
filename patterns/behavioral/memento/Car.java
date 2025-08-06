package patterns.behavioral.memento;

import java.util.NoSuchElementException;

public class Car {

    private String state;
    private CarSnapshot currentSnapshot;

    public Car(String initialState) {
        this.state = initialState;
    }

    public void addState(String addState) {
        state = state + " + " + addState;
    }

    public void printCurrentState() {
        System.out.println("Current state: " + state);
    }

    public CarSnapshot save(CarStateHistory stateHistory) {
        currentSnapshot = new CarSnapshot(state);
        stateHistory.addSnapshot(currentSnapshot);
        return currentSnapshot;
    }

    public void restore(CarSnapshot snapshot) {
        currentSnapshot = snapshot;
        state = snapshot.savedState();
    }

    public void undo(CarStateHistory stateHistory) {
        int index = stateHistory.getSnapshots().indexOf(currentSnapshot);
        if (index < 1) {
            throw new NoSuchElementException("No snapshot found");
        }
        currentSnapshot = stateHistory.getSnapshots().get(index - 1);
        state = currentSnapshot.savedState();
    }

    public void redo(CarStateHistory stateHistory) {
        int index = stateHistory.getSnapshots().indexOf(currentSnapshot);
        if (index > stateHistory.getSnapshots().size() - 1 || index < 0) {
            throw new NoSuchElementException("No snapshot found");
        }
        currentSnapshot = stateHistory.getSnapshots().get(index + 1);
        state = currentSnapshot.savedState();
    }

}