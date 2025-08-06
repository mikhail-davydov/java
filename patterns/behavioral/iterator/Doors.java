package patterns.behavioral.iterator;

public record Doors(int doorsCount) implements CarElement {

    @Override
    public void getCarElement() {
        System.out.println(doorsCount + " doors in the car");
    }

}
