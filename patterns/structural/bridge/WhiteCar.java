package patterns.structural.bridge;

public class WhiteCar extends Car {

    public WhiteCar() {
        super(new WhiteColor());
    }

    @Override
    public void applyColor() {
        System.out.print("Car is ");
        color.setColor();
    }

}
