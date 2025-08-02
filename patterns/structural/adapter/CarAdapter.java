package patterns.structural.adapter;

public class CarAdapter implements CarProcessor {

    private final CarFactory carFactory;

    public CarAdapter(String brand) {
        this.carFactory = new CarFactory(brand);
    }

    @Override
    public void createCar() {
        System.out.println("Call to original");
        carFactory.makeCar();
    }

}