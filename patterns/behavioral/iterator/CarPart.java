package patterns.behavioral.iterator;

public record CarPart(String partName) implements CarElement {

    @Override
    public void getCarElement() {
        System.out.println(partName + " in this car");
    }

}
