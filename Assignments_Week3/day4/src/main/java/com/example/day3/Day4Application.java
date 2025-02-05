package com.example.day3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class Day4Application{

	@Scheduled(fixedRate = 5000)
	public void scheduledmethod(){
		System.out.println("scheduled method tells current time: "+System.currentTimeMillis());
	}

	public static void main(String[] args) {
		SpringApplication.run(Day4Application.class, args);
	}

}
