package patterns.behavioral.observer;

public interface Topic {

    void attach(Consumer consumer);
    void detach(Consumer consumer);
    void notify(String message);

}