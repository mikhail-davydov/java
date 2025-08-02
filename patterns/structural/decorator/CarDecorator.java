package patterns.structural.decorator;

public abstract class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public String getDescription() {
        return car.getDescription();
    }

    @Override
    public double getPrice() {
        return car.getPrice();
    }

    @Override
    public String toString() {
        return "Description: %s, price: %s".formatted(this.getDescription(), this.getPrice());
    }

}