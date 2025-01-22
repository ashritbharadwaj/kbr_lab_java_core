package com.java9.features;
//private method inside an interface
//interface Foof{
//}
 interface Java8DBLogging
{
    default void logInfo(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log Info Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

    default void logWarn(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log warn Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

    default void logError(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log error Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

}

public class A_PrivateMethodInsideInterface {
    public static void main(String[] args) {
        Java8DBLogging logging=new Java8DBLogging() {
            @Override
            public void logInfo(String message) {
                System.out.println(" Step1: Connect to DataBase");
                System.out.println(" Setp2: Log Info Message"+message);
                System.out.println("Setp3: Close the DataBase connection");
            }
        };
        logging.logInfo("Hello");
    }
}
















