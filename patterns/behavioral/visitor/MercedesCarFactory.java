package patterns.behavioral.visitor;

public class MercedesCarFactory implements CarFactory {

    @Override
    public String getBrand() {
        return "Mercedes";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
