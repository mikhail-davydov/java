package patterns.behavioral.state;

public interface CarState {

    void start(CarContext context);

    void stop(CarContext context);

    void status(CarContext context);

}