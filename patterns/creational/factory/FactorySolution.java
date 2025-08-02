package patterns.factory;

import java.util.ArrayList;

public class FactorySolution {

    public static void main(String[] args){
        var cars = new ArrayList<Car>();
        cars.add(new BMWFactory().makeCar());
        cars.add(new MercedesFactory().makeCar());
        cars.add(new VWFactory().makeCar());

        cars.forEach(car -> System.out.println(car.brand()));
    }

}