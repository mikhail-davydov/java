package patterns.behavioral.visitor;

public interface CarFactory {

    String getBrand();

    void accept(Visitor visitor);

}
