package day7.q1;

public class ThreadsafeSingleton {
    private static ThreadsafeSingleton instance = null;
    private ThreadsafeSingleton() {}
    public static synchronized ThreadsafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadsafeSingleton();
        }
        return instance;
    }
}
