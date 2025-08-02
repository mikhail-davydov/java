package patterns.structural.proxy;

public class ProxySolution {

    public static void main(String[] args) {
        var mercedes = new MercedesProxy();
        var bmw = new BMWProxy();

        mercedes.getCar();
        System.out.println();
        bmw.getCar();
        System.out.println();
        mercedes.getCar();
        System.out.println();
        bmw.getCar();
    }

}