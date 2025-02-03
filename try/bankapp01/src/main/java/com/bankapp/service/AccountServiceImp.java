package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.service.aspects.Loggable;
import com.bankapp.util.ConverterUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImp implements AccountService {

    private final AccountRepo accountRepo;
    private final Environment env;


    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepo
                .findAll()
                .stream()
                .map(ConverterUtil::toAccountDto)
                .toList();
    }

    @Override
    public AccountDto getAccountById(int id) {
        return accountRepo
                .findById(id)
                .map(ConverterUtil::toAccountDto)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id "+id));
    }

    @Loggable
    @Override
    public String transfer(TransferDto transferDto) {
        Account fromAccount = ConverterUtil.toAccount(getAccountById(transferDto.getFromId()));
        Account toAccount = ConverterUtil.toAccount(getAccountById(transferDto.getToId()));
        fromAccount.setBalance(fromAccount.getBalance().subtract(transferDto.getAmount()));
        toAccount.setBalance(toAccount.getBalance().add(transferDto.getAmount()));

        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);
        return env.getProperty("transfer.message.success");
    }

    @Override
    public String deposit(DepositDto depositDto) {
        Account account = ConverterUtil.toAccount(getAccountById(depositDto.getId()));
        account.setBalance(account.getBalance().add(depositDto.getAmount()));

        accountRepo.save(account);
        return "Deposited Successfully";
    }

    @Override
    public String withdraw(WithdrawDto withdrawDto) {
        Account account = ConverterUtil.toAccount(getAccountById(withdrawDto.getId()));
        account.setBalance(account.getBalance().subtract(withdrawDto.getAmount()));

        accountRepo.save(account);
        return "Withdraw Successful";
    }
}
