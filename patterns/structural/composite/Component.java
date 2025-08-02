package patterns.structural.composite;

public interface Component {

    String getName();

    ComponentType getType();

    void add(Component component);

    void remove(Component component);

    Component getChild(int i);

    void operation();

}