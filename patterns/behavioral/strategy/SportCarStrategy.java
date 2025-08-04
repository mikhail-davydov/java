package patterns.behavioral.strategy;

public class SportCarStrategy implements AssembleCarStrategy {

    @Override
    public CarType getType() {
        return CarType.SPORT;
    }

    @Override
    public void assemble() {
        System.out.println("Assemble sport car");
    }

}
