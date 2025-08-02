package patterns.abstractFactory;

public class VWCarFactory implements AbstractCarFactory {

    @Override
    public Car makeCar() {
        return new VWCar();
    }

}