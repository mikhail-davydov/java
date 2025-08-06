package patterns.behavioral.iterator;

public class IteratorSolution {

    public static void main(String[] args) {
        var car = new Car()
                .addElement(new Tyres(4))
                .addElement(new Doors(5))
                .addElement(new CarPart("Carcase"))
                .addElement(new CarPart("Driving wheel"))
                .addElement(new CarPart("Engine"));

        for (CarElement element : car) {
            element.getCarElement();
        }

        car.addElement(new CarPart("bumper"));
        car.addElement(new CarPart("backseat"));

        while (car.iterator().hasNext()) {
            car.iterator().next().getCarElement();
        }

    }

}