package patterns.structural.bridge;

public class BlackCar extends Car {

    public BlackCar() {
        super(new BlackColor());
    }

    @Override
    public void applyColor() {
        System.out.print("Car is ");
        color.setColor();
    }

}