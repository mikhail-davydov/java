package patterns.behavioral.visitor;

public class BMWCarFactory implements CarFactory {

    @Override
    public String getBrand() {
        return "BMW";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
