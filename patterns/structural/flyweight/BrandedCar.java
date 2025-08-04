package patterns.structural.flyweight;

public class BrandedCar implements Car {

    private final String brand;

    public BrandedCar(String brand) {
        System.out.printf("Create a new %s car%n", brand);
        this.brand = brand;
    }

}
