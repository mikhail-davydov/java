package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {

    private static final Map<String, Car> BRAND_CAR_MAP = new HashMap<>();

    public static Car createBrandedCar(String brand) {
        if (!BRAND_CAR_MAP.containsKey(brand)) {
            System.out.printf("No existing %s car, create a new one%n", brand);
            var car = new BrandedCar(brand);
            BRAND_CAR_MAP.put(brand, car);
            return car;
        }
        System.out.printf("No need to create a new %s car, use existing one%n", brand);
        return BRAND_CAR_MAP.get(brand);
    }

}