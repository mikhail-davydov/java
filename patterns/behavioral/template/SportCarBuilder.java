package patterns.behavioral.template;

public class SportCarBuilder extends CarBuilder {

    public SportCarBuilder() {
        this.carType = CarType.SPORT;
    }

    @Override
    void addEngine() {
        System.out.println("Add SPORT engine");
    }

}
