package day6.q2;

public class Bank {
    Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public void withdraw(double amount) throws InterruptedException {
        account.withdraw(amount);
    }
}
