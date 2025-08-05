package patterns.behavioral.mediator;

public class MercedesCar extends Car {

    public MercedesCar(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void comesIn() {
        System.out.println("If Mercedes comes in then ... ");
        mediator.notify(this);
    }

    @Override
    void comesOut() {
        System.out.println("Mercedes comes out!");
    }

}
