package patterns.structural.adapter;

public class AdapterSolution {

    public static void main(String[] args){
        var carAdapter = new CarAdapter("Mercedes");
        carAdapter.createCar();
    }

}