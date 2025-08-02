package patterns.singleton;

public class SingletonSolution {

    public static void main(String[] args) {

        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();

        if (first == second) {
            System.out.println("Equal instances");
            return;
        }

        System.out.println("Not equal instances");

    }

}