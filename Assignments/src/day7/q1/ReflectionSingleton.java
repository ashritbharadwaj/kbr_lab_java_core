package day7.q1;

public class ReflectionSingleton {
    private static final ReflectionSingleton instance = new ReflectionSingleton();

    private ReflectionSingleton() {
        if (instance != null) {
            throw new IllegalStateException("Instance already exists");
        }
    }

    public static ReflectionSingleton getInstance() {
        return instance;
    }
}

