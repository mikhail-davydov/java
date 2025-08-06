package patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Car implements Iterable<CarElement> {

    private final List<CarElement> carElements = new ArrayList<>();

    @Override
    public Iterator<CarElement> iterator() {
        return new CarElementsIterator(this);
    }

    public Car addElement(CarElement element) {
        carElements.add(element);
        return this;
    }

    private class CarElementsIterator implements Iterator<CarElement> {

        private final Car car;

        public CarElementsIterator(Car car) {
            this.car = car;
        }

        @Override
        public boolean hasNext() {
            return !car.carElements.isEmpty();
        }

        @Override
        public CarElement next() {
            if (car.carElements.isEmpty()) {
                throw new NoSuchElementException("No car elements left");
            }
            return car.carElements.removeFirst();
        }
    }

}