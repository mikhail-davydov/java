package patterns.structural.decorator;

public class SpoilerDecorator extends CarDecorator {
    public SpoilerDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return "%s with spoiler".formatted(car.getDescription());
    }

    @Override
    public double getPrice() {
        return car.getPrice() + 20_000;
    }


}
