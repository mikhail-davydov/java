package patterns.creational.abstractFactory;

public class BMWCarFactory implements AbstractCarFactory {

    @Override
    public Car makeCar() {
        return new BMWCar();
    }

}