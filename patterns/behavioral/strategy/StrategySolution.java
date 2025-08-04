package patterns.behavioral.strategy;

public class StrategySolution {

    public static void main(String[] args){
        var carAssembleShop = new CarAssemblyShop();

        carAssembleShop.setAssembleCarStrategy(new SportCarStrategy());
        carAssembleShop.assemble();

        carAssembleShop.setAssembleCarStrategy(new CityCarStrategy());
        carAssembleShop.assemble();
    }

}