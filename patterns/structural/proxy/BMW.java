package patterns.structural.proxy;

public class BMW implements Car {

    public BMW() {
        assemble();
    }

    @Override
    public void getCar() {
        System.out.println("Get BMW");
    }

    private void assemble() {
        System.out.println("Assemble new BMW");
    }

}