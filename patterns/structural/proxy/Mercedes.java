package patterns.structural.proxy;

public class Mercedes implements Car {

    public Mercedes() {
        assemble();
    }

    @Override
    public void getCar() {
        System.out.println("Get Mercedes");
    }

    private void assemble() {
        System.out.println("Assemble new Mercedes");
    }

}