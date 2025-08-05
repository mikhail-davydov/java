package patterns.behavioral.visitor;

import java.util.List;

public class VisitorSolution {

    public static void main(String[] args){
        var factories = List.of(new MercedesCarFactory(), new BMWCarFactory(), new VWCarFactory());
        var inspector = new FactoryVisitor();

        factories.forEach(carFactory -> carFactory.accept(inspector));
    }

}