package patterns.structural.bridge;

public class BridgeSolution {

    public static void main(String[] args){
        var blackCar = new BlackCar();
        var whiteCar = new WhiteCar();

        blackCar.applyColor();
        whiteCar.applyColor();
    }

}