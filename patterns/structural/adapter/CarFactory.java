package patterns.structural.adapter;

public record CarFactory(String brand) {

    public void makeCar() {
        System.out.println("Make %s car".formatted(this.brand));
    }

}