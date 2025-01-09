package day2.q4;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeRecordSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Adding some employees for demonstration
        employees.add(new SalariedEmployee("Alice", "E001", 1000));
        employees.add(new HourlyEmployee("Bob", "E002", 20, 40));
        employees.add(new CommissionEmployee("Charlie", "E003", 5000, 10));

        while (true) {
            System.out.println("\n1. Get Weekly Salary\n2. Increase Salary\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    String id = scanner.next();
                    Employee emp = findEmployeeById(employees, id);
                    if (emp != null) {
                        System.out.println("Weekly Salary: " + emp.getWeeklySalary());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    id = scanner.next();
                    emp = findEmployeeById(employees, id);
                    if (emp != null) {
                        System.out.print("Enter percentage increase: ");
                        double percentage = scanner.nextDouble();
                        emp.increaseSalary(percentage);
                        System.out.println("Salary increased.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the system. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static Employee findEmployeeById(ArrayList<Employee> employees, String id) {
        for (Employee emp : employees) {
            if (emp.employeeId.equals(id)) {
                return emp;
            }
        }
        return null;
    }
}
