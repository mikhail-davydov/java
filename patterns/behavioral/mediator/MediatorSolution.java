package patterns.behavioral.mediator;

public class MediatorSolution {

    public static void main(String[] args){
        var mediator = new CarMediator();

        var mercedes = new MercedesCar(mediator);
        var bmw = new BMWCar(mediator);
        var vw = new VWCar(mediator);

        mediator.setMercedes(mercedes);
        mediator.setBmw(bmw);
        mediator.setVw(vw);

        mercedes.comesIn();
        bmw.comesIn();
        vw.comesIn();
    }

}