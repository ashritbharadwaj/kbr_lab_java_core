package day7.q1;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instance = null;

    private StaticBlockSingleton() {
        System.out.println("Object is created");
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
