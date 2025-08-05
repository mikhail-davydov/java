package patterns.behavioral.state;

public class CarContext {

    private final String brand;
    private CarState currentState;

    public CarContext(String brand) {
        this.brand = brand;
        this.currentState = new StopState();
    }

    public String getBrand() {
        return brand;
    }

    public void setCurrentState(CarState currentState) {
        this.currentState = currentState;
    }

    public void start() {
        currentState.start(this);
    }

    public void stop() {
        currentState.stop(this);
    }

    public void status() {
        currentState.status(this);
    }

}
