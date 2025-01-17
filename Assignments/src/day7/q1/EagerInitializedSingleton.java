package day7.q1;

public class EagerInitializedSingleton {
    private static EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
        System.out.println("EagerInitialization constructor is called.");
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
