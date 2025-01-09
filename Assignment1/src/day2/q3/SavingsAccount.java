package day2.q3;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.05;
    private static final double MINIMUM_BALANCE = 5000;
    private double maxWithdrawLimit;

    public SavingsAccount(String name, String accountNumber, double accountBalance) {
        super(name, accountNumber, accountBalance);
        this.maxWithdrawLimit = accountBalance;
    }

    @Override
    public double getBalance() {
        return accountBalance + (accountBalance * INTEREST_RATE);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= maxWithdrawLimit && (accountBalance - amount) >= MINIMUM_BALANCE) {
            accountBalance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }
}
