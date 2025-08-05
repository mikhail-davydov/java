package patterns.behavioral.state;

public class StopState implements CarState {
    @Override
    public void start(CarContext context) {
        System.out.println(context.getBrand() + " is starting");
        context.setCurrentState(new StartState());
    }

    @Override
    public void stop(CarContext context) {
        System.out.println(context.getBrand() + " is already stopped");
    }

    @Override
    public void status(CarContext context) {
        System.out.println(context.getBrand() + " is stopped");
    }
}
