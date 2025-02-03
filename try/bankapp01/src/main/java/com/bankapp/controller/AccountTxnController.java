package com.bankapp.controller;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AccountTxnController {

    private final AccountService accountService;

    @Autowired
    public AccountTxnController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody @Valid TransferDto transferDto) {
        return ResponseEntity.ok(accountService.transfer(transferDto));
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody DepositDto depositDto) {
        return ResponseEntity.ok(accountService.deposit(depositDto));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawDto withdrawDto) {
        return ResponseEntity.ok(accountService.withdraw(withdrawDto));
    }

}
