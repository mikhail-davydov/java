package patterns.structural.decorator;

public class Mercedes implements Car {

    @Override
    public String getDescription() {
        return "Mercedes";
    }

    @Override
    public double getPrice() {
        return 100_000;
    }

    @Override
    public String toString() {
        return "Description: %s, price: %s".formatted(this.getDescription(), this.getPrice());
    }

}
