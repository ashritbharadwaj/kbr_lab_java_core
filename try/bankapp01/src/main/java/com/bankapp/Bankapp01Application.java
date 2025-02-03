package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.math.BigDecimal;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class Bankapp01Application implements CommandLineRunner {

	@Autowired
	private AccountRepo accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(Bankapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("John Doe", new BigDecimal("1000")));
		accountRepo.save(new Account("Jane Doe", new BigDecimal("2000")));
	}
}
