package patterns.factory;

public class VWFactory implements CarFactory {

    @Override
    public Car makeCar() {
        return new VW();
    }

}
