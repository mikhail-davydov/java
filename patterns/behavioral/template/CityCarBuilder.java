package patterns.behavioral.template;

public class CityCarBuilder extends CarBuilder {

    public CityCarBuilder() {
        this.carType = CarType.CITY;
    }

    @Override
    void addEngine() {
        System.out.println("Add ordinary engine");
    }

}
