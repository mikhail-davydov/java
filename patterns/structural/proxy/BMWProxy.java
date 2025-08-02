package patterns.structural.proxy;

public class BMWProxy implements Car {

    private Car car;

    @Override
    public void getCar() {
        if (null == car) {
            System.out.println("No BMW yet");
            car = new BMW();
            car.getCar();
            return;
        }

        System.out.println("No need to assemble a new BMW, you already own one");
        car.getCar();
    }

}