package patterns.structural.flyweight;

public class FlyweightSolution {

    public static void main(String[] args){
        CarFactory.createBrandedCar("Mercedes");
        CarFactory.createBrandedCar("BMW");
        CarFactory.createBrandedCar("Mercedes");
    }

}