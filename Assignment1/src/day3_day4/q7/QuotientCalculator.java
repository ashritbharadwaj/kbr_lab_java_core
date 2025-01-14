package day3_day4.q7;

import java.util.Scanner;

public class QuotientCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the 2 numbers:");

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        try {
            int quotient = a / b;
            System.out.println("The quotient of " + a + "/" + b + " = " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("DivideByZeroException caught");
        } finally {
            System.out.println("Inside finally block");
        }

        scanner.close();
    }
}
