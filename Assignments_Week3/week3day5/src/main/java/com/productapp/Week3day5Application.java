package com.productapp;

import com.productapp.entities.Product;
import com.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Week3day5Application implements CommandLineRunner {
	@Autowired
	ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(Week3day5Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		productRepo.save(new Product("Laptop", 10000, LocalDate.now()));
		productRepo.save(new Product("Mobile", 5000, LocalDate.now().plusDays(1)));
		productRepo.save(new Product("Tablet", 3000, LocalDate.now().plusDays(2)));
	}
}
