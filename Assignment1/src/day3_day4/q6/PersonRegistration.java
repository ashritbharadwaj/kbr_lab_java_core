package day3_day4.q6;

import java.util.Scanner;

public class PersonRegistration {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age;

        try {
            age = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Age must be a valid integer.");
            return;
        }

        try {
            registerPerson(name, age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void registerPerson(String name, int age) throws InvalidAgeException {
        if (age < 18 || age >= 60) {
            throw new InvalidAgeException("Age must be between 18 and 59.");
        } else {
            System.out.println("Registration successful for " + name + " with age " + age);
        }
    }
}
