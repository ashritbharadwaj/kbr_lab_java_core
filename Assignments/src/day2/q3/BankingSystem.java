package day2.q3;

import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;

        System.out.println("Welcome to the Banking System");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("Choose account type: 1. Savings 2. Current");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter initial deposit amount: ");
            double initialDeposit = scanner.nextDouble();
            account = new SavingsAccount(name, accountNumber, initialDeposit);
        } else if (choice == 2) {
            System.out.print("Enter initial deposit amount: ");
            double initialDeposit = scanner.nextDouble();
            System.out.print("Enter trade license number: ");
            String tradeLicenseNumber = scanner.next();
            System.out.print("Enter overdraft limit: ");
            double overdraft = scanner.nextDouble();
            account = new CurrentAccount(name, accountNumber, initialDeposit, tradeLicenseNumber, overdraft);
        } else {
            System.out.println("Invalid account type.");
            System.exit(0);
        }

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
