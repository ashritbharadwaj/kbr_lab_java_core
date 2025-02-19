package com.productapp;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.awt.print.Book;
import java.util.List;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//String name, Integer qty, String vendor, Double cost

		//insert();

//		mgfindAll();

//		mgfindById();

//		mginsert();

//		mginsertAll();

//		mgfindAndModify();

//		mgupdateMulti();

//		mgfindAndRemove();

//		mgupsert();

//		System.out.println(findProductsByVendor("AB electronic"));

//		System.out.println(findProductsByQtysGreaterThan(10));
	}

	public List<Product> findProductsByQtysGreaterThan(int qty) {

		Query query = new Query(Criteria.where("qty").gt(qty));
		return mongoTemplate.find(query, Product.class);
	}

	public List<Product> findProductsByVendor(String vendor) {
		Query query = new Query(Criteria.where("vendor").is(vendor));
		return mongoTemplate.find(query, Product.class);
	}

	private void mgupsert() {
		Query query= new Query();
		query.addCriteria(Criteria.where("id").is(510));
		Update update = new Update();
		update.set("cost", 1065.25);
		update.set("name", "Core Java");
		mongoTemplate.upsert(query, update, Product.class);
	}

	private void mgfindAndRemove() {
		System.out.println(mongoTemplate.findAndRemove(new Query().addCriteria(Criteria.where("id").is("67b5a712799b325bb664c28b")), Product.class));
	}

	private void mgupdateMulti() {
		System.out.println(mongoTemplate.updateMulti(new Query().addCriteria(Criteria.where("qty").lte(20)), new Update().set("cost", 100000), Product.class).getModifiedCount());
	}

	private void mgfindAndModify() {
		Query query= new Query();
		query.addCriteria(Criteria.where("id").is("67b5a712799b325bb664c28b"));

		Update update = new Update();
		update.set("cost", 100000.0);
		update.set("name", "Apple Laptop");

		mongoTemplate.findAndModify(query, update, Product.class);

		System.out.println("Data Modified");
	}

	private void mgfindById() {
		System.out.println(mongoTemplate.findById("67b5a712799b325bb664c28b", Product.class));
	}

	private void mgfindAll() {
		System.out.println(mongoTemplate.findAll(Product.class));
	}

	private void mginsertAll() {
		mongoTemplate.insertAll(List.of(new Product("hp laptop", 20, "CD electronic", 4000000.0),
				new Product("lenovo laptop", 30, "EF electronic", 5000000.0),
				new Product("apple laptop", 10, "AP electronic", 15000000.0)));
	}

	private void mginsert() {
		mongoTemplate.insert(List.of(new Product("hp laptop", 20, "CD electronic", 4000000.0),
				new Product("lenovo laptop", 30, "EF electronic", 5000000.0),
				new Product("apple laptop", 10, "AP electronic", 15000000.0)), "products");
	}

	private void insert() {
		productRepo.save(new Product("dell laptop", 30, "AB electronic", 5000000.0));
		productRepo.save(new Product("mouse", 300, "MA electronic", 500.0));
		productRepo.save(new Product("Keyboard", 20, "ZA electronic", 600.0));
		System.out.println("------------------------");
	}
}
