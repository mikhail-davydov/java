package patterns.behavioral.observer;

public class CarSystemConsumer implements Consumer {

    private final String brand;

    public CarSystemConsumer(String brand) {
        this.brand = brand;
    }

    @Override
    public void receive(String message) {
        System.out.printf("%s car system received a message: %s%n", brand, message);
    }

}
