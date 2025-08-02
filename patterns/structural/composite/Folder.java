package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {

    private final List<Component> components = new ArrayList<>();
    private final ComponentType type = ComponentType.FOLDER;
    private final String name;

    public Folder(String name) {
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
        System.out.println("Add %s: %s, folder: %s".formatted(component.getType(), component.getName(), this.name));
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        System.out.println("Delete %s: %s, folder: %s".formatted(component.getType(), component.getName(), this.name));
        components.remove(component);
    }

    @Override
    public Component getChild(int i) {
        var child = components.get(i);
        System.out.println("Get %s: %s, folder: %s".formatted(child.getType(), child.getName(), this.name));
        return null;
    }

    @Override
    public void operation() {
        System.out.println("Processing %s: %s".formatted(type, name));
        components.forEach(Component::operation);
    }

}
