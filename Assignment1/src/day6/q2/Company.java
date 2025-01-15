package day6.q2;

public class Company {
    Account account;

    public Company(Account account) {
        this.account = account;
    }

    public void deposit(double amount) throws InterruptedException {
        account.deposit(amount);
    }
}
