package patterns.structural.bridge;

public abstract class Car {

    protected final Color color;

    public Car(Color color) {
        this.color = color;
    }

    public abstract void applyColor();

}