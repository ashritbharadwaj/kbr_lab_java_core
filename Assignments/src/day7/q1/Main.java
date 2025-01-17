package day7.q1;

public class Main {
    public static void main(String[] args) {
        EagerInitializedSingleton obj = EagerInitializedSingleton.getInstance();
        System.out.println(obj);

        LazyInitializedSingleton obj2 = LazyInitializedSingleton.getInstance();
        System.out.println(obj2);

        StaticBlockSingleton obj3 = StaticBlockSingleton.getInstance();
        System.out.println(obj3);

        ClonedSingleton obj4 = ClonedSingleton.getInstance();
        System.out.println(obj4);

        SerializedSingleton obj5 = SerializedSingleton.getInstance();
        System.out.println(obj5);

        ThreadsafeSingleton obj6 = ThreadsafeSingleton.getInstance();
        System.out.println(obj6);

        ReflectionSingleton obj7 = ReflectionSingleton.getInstance();
        System.out.println(obj7);
    }
}
