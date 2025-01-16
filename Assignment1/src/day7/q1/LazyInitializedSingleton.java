package day7.q1;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance = null;
    private LazyInitializedSingleton() {
        System.out.println("Object is created");
    }
    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
