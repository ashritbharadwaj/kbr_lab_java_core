package com.bankapp.service;

import com.bankapp.entities.Account;
import com.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.repositories.AccountDao;
import com.bankapp.service.aspects.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImp(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Loggable
    @Override
    public void transfer(int from, int to, int amount) {
        Account fromAccount = accountDao.findById(from).orElse(null);
        Account toAccount = accountDao.findById(to).orElse(null);
        if(fromAccount != null && toAccount != null) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            accountDao.save(fromAccount);
            accountDao.save(toAccount);
        }else{
            throw new AccountNotFoundException("Account not found");
        }
    }

    @Override
    public void deposit(int id, double amount) {
        Account account = accountDao.findById(id).orElse(null);
        if(account != null) {
            account.setBalance(account.getBalance() + amount);
            accountDao.save(account);
        }else{
            throw new AccountNotFoundException("Account not found");
        }
    }

    @Override
    public Account getAccount(int id) {
        Account account = accountDao.findById(id).orElse(null);
        if(account != null) {
            return account;
        }else{
            throw new AccountNotFoundException("Account not found");
        }
    }
}
