package patterns.factory;

public class BMWFactory implements CarFactory {

    @Override
    public Car makeCar() {
        return new BMW();
    }

}