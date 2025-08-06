package patterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class CarStateHistory {

    private final List<CarSnapshot> snapshots = new ArrayList<>();

    public void addSnapshot(CarSnapshot snapshot) {
        snapshots.add(snapshot);
    }

    public CarSnapshot getSnapshot(int index) {
        return snapshots.get(index);
    }

    public List<CarSnapshot> getSnapshots() {
        return snapshots;
    }

}