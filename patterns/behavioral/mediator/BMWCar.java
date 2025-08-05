package patterns.behavioral.mediator;

public class BMWCar extends Car {

    public BMWCar(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void comesIn() {
        System.out.println("If BMW comes in then ... ");
        mediator.notify(this);
    }

    public void comesOut() {
        System.out.println("BMW comes out!");
    }

}
