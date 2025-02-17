package com.mongoapp;

import com.mongoapp.entities.Peak;
import com.mongoapp.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@SpringBootApplication
public class MongodbappApplication implements CommandLineRunner {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	Repo repo;

	public static void main(String[] args) {
		SpringApplication.run(MongodbappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(mongoTemplate!=null) {
			System.out.println("Connected to DB");
		}

//		System.out.println(repo.findAll());

		findbyname();
		findbynamenot();

		System.out.println("\nWrite Queries query searches for documents whose height value is greater than 8500");
		System.out.println(repo.findByHeightGreaterThan(8500));
		System.out.println("\nWrite Queries to selecting a mountain that matches the name Everest and the exact height of 8848 meters");
		System.out.println(repo.findByNameAndHeight("Everest", 8848));
		System.out.println("\nWrite Queries to selecting a mountain that matches the name Everest or the exact height of 8848 meters");
		System.out.println(repo.findByNameOrHeight("Everest", 8848));
		System.out.println("\nFind mountains located in both China and Nepal?");
		System.out.println(repo.findPeaksInLocations(List.of("China", "Nepal")));
		System.out.println("\nWrite query to found peek with more than 1000 ascents");
		System.out.println(repo.findByAscentsTotalGreaterThan(1000));
	}

	private void findbyname() {
		System.out.println("\nWrite Query to returns any documents whose name value is equal to Everest");
		List<Peak> peaks = repo.findByName("Everest");
		peaks.forEach(System.out::println);
	}

	private void findbynamenot() {
		System.out.println("\nWrite Query to returns any documents whose name value is not equal to Everest");
		List<Peak> peaks = repo.findByNameNot("Everest");
		peaks.forEach(System.out::println);
	}
}
