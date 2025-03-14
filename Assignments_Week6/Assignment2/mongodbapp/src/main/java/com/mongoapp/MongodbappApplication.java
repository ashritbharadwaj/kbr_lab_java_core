package com.mongoapp;

import com.mongoapp.entities.Peak;
import com.mongoapp.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.PageRanges;
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



		System.out.println("\nWrite Queries to selecting a mountain that matches the name Everest and the exact height of 8848 meters");
		System.out.println(repo.findByNameAndHeight("Everest", 8848));
		System.out.println("\nFind mountains located in both China and Nepal?");
		System.out.println(repo.findPeaksInLocations(List.of("China", "Nepal")));
		System.out.println("\nWrite query to found peek with more than 1000 ascents");
		System.out.println(repo.findByAscentsTotalGreaterThan(1000));
		System.out.println("\nReturn any documents describing mountains that were first ascended in winter only after the year 2000");
		System.out.println();
		System.out.println(repo.findMountainsFirstAscendedInWinterAfterYear(2000));
		System.out.println("\nReturn data from each document, but will exclude the ascents and location fields");
		System.out.println(repo.findAllExcludingAscentsAndLocation());
		System.out.println("\nWrite Queries which will retrieve only three mountain peaks from the collection");
		Pageable pageable = PageRequest.of(0, 3);
		System.out.println(repo.findTopPeaks(pageable));
	}
}
