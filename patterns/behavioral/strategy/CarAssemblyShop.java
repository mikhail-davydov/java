package patterns.behavioral.strategy;

public class CarAssemblyShop {

    private AssembleCarStrategy assembleCarStrategy;

    public CarAssemblyShop() {
        System.out.println("Create Car Assembly Shop");
    }

    public void setAssembleCarStrategy(AssembleCarStrategy assembleCarStrategy) {
        System.out.println("Set strategy: " + assembleCarStrategy.getType());
        this.assembleCarStrategy = assembleCarStrategy;
    }

    public void assemble() {
        assembleCarStrategy.assemble();
    }

}