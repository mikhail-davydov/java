package patterns.abstractFactory;

public class MercedesCarFactory implements AbstractCarFactory {

    @Override
    public Car makeCar() {
        return new MercedesCar();
    }

}