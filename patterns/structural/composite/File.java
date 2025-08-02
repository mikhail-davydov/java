package patterns.structural.composite;

public class File implements Component {

    private final String name;
    private final ComponentType type = ComponentType.FILE;

    public File(String name) {
        this.name = name;
        System.out.println("%s %s created".formatted(this.type, this.name));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public Component getChild(int i) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void operation() {
        System.out.println("Processing %s: %s".formatted(type, name));
    }

}
