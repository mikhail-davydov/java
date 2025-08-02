package patterns.prototype;

public class Car implements Prototype {

    private String brand;
    private CarSettings carSettings;

    @Override
    public Car clone() {
        try {
            Car clone = (Car) super.clone();
            // deep copy here
            clone.carSettings = carSettings.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException("Not supported operation");
        }
    }

    @Override
    public String toString() {
        return "{brand: " + this.brand + ", carSettings: " + this.carSettings.toString() + "}";
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Car setCarSettings(CarSettings carSettings) {
        this.carSettings = carSettings;
        return this;
    }
}
