package patterns.behavioral.iterator;

public record Tyres(int tyresCount) implements CarElement {

    @Override
    public void getCarElement() {
        System.out.println(tyresCount + " tyres in the car");
    }

}
