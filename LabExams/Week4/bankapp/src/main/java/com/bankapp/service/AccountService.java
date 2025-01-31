package com.bankapp.service;

import com.bankapp.entities.Account;

public interface AccountService {
    public void transfer(int from, int to, int amount);
    public void deposit(int id, double amount);
    public Account getAccount(int id);
}
