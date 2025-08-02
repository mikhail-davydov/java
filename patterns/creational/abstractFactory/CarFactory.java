package patterns.abstractFactory;

public class CarFactory {

    private CarFactory() {

    }

    public static Car createBrandedCar(AbstractCarFactory abstractCarFactory) {
        return abstractCarFactory.makeCar();
    }

}