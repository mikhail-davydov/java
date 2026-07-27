package patterns.creational.singleton;

public class Singleton {

    private static Singleton INSTANCE;
    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

}
