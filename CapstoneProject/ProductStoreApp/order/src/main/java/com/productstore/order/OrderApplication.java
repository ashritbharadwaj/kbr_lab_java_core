package com.productstore.order;

import com.productstore.order.entity.Order;
import com.productstore.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDateTime;

@EnableFeignClients("com.productstore.order.serviceproxy")
@SpringBootApplication
public class OrderApplication implements CommandLineRunner {

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		orderRepository.save(new Order( 1L, 1, "Pending", LocalDateTime.now()));
		orderRepository.save(new Order( 2L, 1, "Pending", LocalDateTime.now()));
		orderRepository.save(new Order( 3L, 1, "Pending", LocalDateTime.now()));
	}
}
