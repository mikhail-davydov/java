package patterns.builder;

public class BuilderSolution {

    public static void main(String[] args){
        Car bmw = new Car.Builder().brand("bmw").build();
        System.out.println("Car: " + bmw);
    }

}