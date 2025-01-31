package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.repositories.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	@Autowired
	private AccountDao accountDao;

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountDao.save(new Account(1, "John Doe", 1000.00));
		accountDao.save(new Account(2, "Cena Doe", 2000.00));
	}
}
