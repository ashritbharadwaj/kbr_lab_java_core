package day6.q2;

import static java.lang.Thread.sleep;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) throws InterruptedException {
        balance += amount;
        System.out.println("Deposit by Thread: " + Thread.currentThread().getName()+" balance: "+balance);
        sleep(1000);
    }

    public synchronized void withdraw(double amount) throws InterruptedException {
        if(balance-amount < 0) {
            synchronized (this) {
                while(balance-amount < 0) {
                    wait();
                }
            }
        }
        balance -= amount;
        System.out.println("Withdraw by Thread: " + Thread.currentThread().getName()+" balance: "+balance);
        sleep(1000);
    }
}
