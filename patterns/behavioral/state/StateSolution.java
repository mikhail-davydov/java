package patterns.behavioral.state;

public class StateSolution {

    public static void main(String[] args){
        var mercedes = new CarContext("Mercedes");
        mercedes.status();

        mercedes.start();
        mercedes.status();

        mercedes.stop();
        mercedes.status();
        mercedes.stop();
    }

}