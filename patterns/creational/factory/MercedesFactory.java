package patterns.creational.factory;

public class MercedesFactory implements CarFactory {

    @Override
    public Car makeCar() {
        return new Mercedes();
    }

}
