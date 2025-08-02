package patterns.prototype;

public class PrototypeSolution {

    public static void main(String[] args){
        var blackCarSettings = new CarSettings().setType("Sedan").setColor("Black");
        var mercedes = new Car().setBrand("Mercedes").setCarSettings(blackCarSettings);
        var mercedesClone = mercedes.clone();

        // set white color for mercedes, clone remains black
        blackCarSettings.setColor("White");

        System.out.println("mercedes: " + mercedes);
        System.out.println("mercedesClone: " + mercedesClone);
    }

}