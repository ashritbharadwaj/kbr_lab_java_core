package day2.q3;

public abstract class Account {
    protected String name;
    protected String accountNumber;
    protected double accountBalance;

    public Account(String name, String accountNumber, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract double getBalance();

    public abstract void withdraw(double amount);
}
