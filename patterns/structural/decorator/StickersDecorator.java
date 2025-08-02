package patterns.structural.decorator;

public class StickersDecorator extends CarDecorator {
    public StickersDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return "%s with stickers".formatted(car.getDescription());
    }

    @Override
    public double getPrice() {
        return car.getPrice() + 10_000;
    }

}
