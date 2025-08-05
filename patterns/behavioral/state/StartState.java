package patterns.behavioral.state;

public class StartState implements CarState {

    @Override
    public void start(CarContext context) {
        System.out.println(context.getBrand() + " is already started");
    }

    @Override
    public void stop(CarContext context) {
        System.out.println(context.getBrand() + " is stopping");
        context.setCurrentState(new StopState());
    }

    @Override
    public void status(CarContext context) {
        System.out.println(context.getBrand() + " is started");
    }

}
