package patterns.behavioral.mediator;

public class VWCar extends Car {

    public VWCar(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void comesIn() {
        System.out.println("If VW comes in then ... ");
        mediator.notify(this);
    }

    @Override
    void comesOut() {
        // nothing here
        return;
    }

}
