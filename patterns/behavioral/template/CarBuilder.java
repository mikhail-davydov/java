package patterns.behavioral.template;

public abstract class CarBuilder {

    protected CarType carType;

    public void build() {
        System.out.println("Start building a car of type: " + this.carType);
        buildCarcase();
        addDoors();
        addEngine();
        addTyres();
    }

    abstract void addEngine();

    private void addTyres() {
        System.out.println("Add addTyres");
    }

    private void addDoors() {
        System.out.println("Add doors");
    }

    private void buildCarcase() {
        System.out.println("Build carcase");
    }

}