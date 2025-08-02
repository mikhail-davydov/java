package patterns.builder;

public class Car {

    private final String brand;

    private Car(Builder builder) {
        this.brand = builder.brand;
    }

    @Override
    public String toString() {
        return brand;
    }

    public static class Builder {

        private String brand;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

}