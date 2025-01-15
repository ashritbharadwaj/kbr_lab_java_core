package day6.q2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000.0);
        Bank bank = new Bank(account);
        Company company = new Company(account);

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    bank.withdraw(1000.0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threadList.add(thread);
            thread = new Thread(() -> {
                try {
                    company.deposit(1000.0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Bank balance: " + account.getBalance());
    }
}
