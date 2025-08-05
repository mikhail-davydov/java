package patterns.behavioral.mediator;

public abstract class Car {

    protected Mediator mediator;

    public Car(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void comesIn();

    abstract void comesOut();

}
