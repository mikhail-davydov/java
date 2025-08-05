package patterns.behavioral.mediator;

public class CarMediator implements Mediator {

    private MercedesCar mercedes;
    private BMWCar bmw;
    private VWCar vw;

    @Override
    public void notify(Car sender) {
        if (sender instanceof MercedesCar) {
            bmw.comesOut();
            return;
        }

        if (sender instanceof BMWCar) {
            mercedes.comesOut();
            return;
        }

        System.out.println("that's alright!");
    }

    public void setMercedes(MercedesCar mercedes) {
        this.mercedes = mercedes;
    }

    public void setBmw(BMWCar bmw) {
        this.bmw = bmw;
    }

    public void setVw(VWCar vw) {
        this.vw = vw;
    }

}
