package day2.q3;

public class CurrentAccount extends Account {
    private String tradeLicenseNumber;
    private double overdraft;

    public CurrentAccount(String name, String accountNumber, double accountBalance, String tradeLicenseNumber, double overdraft) {
        super(name, accountNumber, accountBalance);
        this.tradeLicenseNumber = tradeLicenseNumber;
        this.overdraft = overdraft;
    }

    @Override
    public double getBalance() {
        return accountBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= (accountBalance + overdraft)) {
            accountBalance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or exceeds overdraft limit.");
        }
    }
}
