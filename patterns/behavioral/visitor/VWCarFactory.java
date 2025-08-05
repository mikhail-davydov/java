package patterns.behavioral.visitor;

public class VWCarFactory implements CarFactory {

    @Override
    public String getBrand() {
        return "VW";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
