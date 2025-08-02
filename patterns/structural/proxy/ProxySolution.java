package patterns.structural.proxy;

public class ProxySolution {

    private final static String LINE_DELIMITER = "";

    public static void main(String[] args) {
        var mercedes = new MercedesProxy();
        var bmw = new BMWProxy();

        mercedes.getCar();
        System.out.println(LINE_DELIMITER);
        bmw.getCar();
        System.out.println(LINE_DELIMITER);
        mercedes.getCar();
        System.out.println(LINE_DELIMITER);
        bmw.getCar();
    }

}