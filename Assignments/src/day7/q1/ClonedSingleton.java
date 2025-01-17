package day7.q1;

public class ClonedSingleton implements Cloneable {
    private static final ClonedSingleton instance = new ClonedSingleton();

    private ClonedSingleton() {}

    public static ClonedSingleton getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
