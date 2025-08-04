package patterns.behavioral.strategy;

public class CityCarStrategy implements AssembleCarStrategy {

    @Override
    public CarType getType() {
        return CarType.CITY;
    }

    @Override
    public void assemble() {
        System.out.println("Assemble city car");
    }

}
