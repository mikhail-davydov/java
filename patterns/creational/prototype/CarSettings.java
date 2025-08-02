package patterns.prototype;

public class CarSettings implements Cloneable {

    private String color;
    private String type;

    @Override
    public CarSettings clone() {
        try {
            return (CarSettings) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "{color: " +  this.color + ", type: " + this.type + "}";
    }

    public CarSettings setColor(String color) {
        this.color = color;
        return this;
    }

    public CarSettings setType(String type) {
        this.type = type;
        return this;
    }

}
