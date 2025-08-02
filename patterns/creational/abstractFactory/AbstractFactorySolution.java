package patterns.abstractFactory;

public class AbstractFactorySolution {

    public static void main(String[] args) {

        Car mercedes = CarFactory.createBrandedCar(new MercedesCarFactory());
        Car bmw = CarFactory.createBrandedCar(new BMWCarFactory());
        Car vw = CarFactory.createBrandedCar(new VWCarFactory());

        System.out.println("Car brand: " + mercedes.brand());
        System.out.println("Car brand: " + bmw.brand());
        System.out.println("Car brand: " + vw.brand());

    }

}