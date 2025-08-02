package patterns.structural.facade;

public class FacadeSolution {

    public static void main(String[] args){
        var driveFacade = new DriveFacade(new Engine(), new Transmission(), new GasPedal());

        System.out.println("For driving follow the steps:");
        driveFacade.drive();

        System.out.println("\nTo stop follow the steps:");
        driveFacade.stop();
    }

}