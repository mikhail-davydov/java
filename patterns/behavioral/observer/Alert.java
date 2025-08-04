package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Alert implements Topic {

    private final List<Consumer> consumers = new ArrayList<>();

    @Override
    public void attach(Consumer consumer) {
        consumers.add(consumer);
    }

    @Override
    public void detach(Consumer consumer) {
        consumers.remove(consumer);
    }

    @Override
    public void notify(String message) {
        System.out.printf("Send message: %s%n", message);
        consumers.forEach(consumer -> consumer.receive(message));
    }

}
