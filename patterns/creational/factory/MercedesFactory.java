package patterns.factory;

public class MercedesFactory implements CarFactory {

    @Override
    public Car makeCar() {
        return new Mercedes();
    }

}
