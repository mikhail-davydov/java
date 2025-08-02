package patterns.structural.proxy;

public class MercedesProxy implements Car {

    private Car car;

    @Override
    public void getCar() {
        if (null == car) {
            System.out.println("No Mercedes yet");
            car = new Mercedes();
            car.getCar();
            return;
        }

        System.out.println("No need to assemble a new Mercedes, you already own one");
        car.getCar();
    }

}