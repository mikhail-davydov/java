package patterns.behavioral.visitor;

public class FactoryVisitor implements Visitor {

    @Override
    public void visit(CarFactory carFactory) {
        System.out.println(carFactory.getBrand() + " factory inspection");
    }

}
