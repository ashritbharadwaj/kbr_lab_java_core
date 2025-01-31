package com.bankapp.controller;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("account/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable int id) {
        System.out.println(accountService.getAccount(id));
        return ResponseEntity.status(200).body(accountService.getAccount(id));
    }

    @PutMapping("account/{id}")
    public ResponseEntity<Void> deposit(@PathVariable int id, @RequestParam double amount) {
        accountService.deposit(id, amount);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("account/transfer")
    public ResponseEntity<Void> transfer(@RequestParam int from, @RequestParam int to, @RequestParam int amount) {
        accountService.transfer(from, to, amount);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
