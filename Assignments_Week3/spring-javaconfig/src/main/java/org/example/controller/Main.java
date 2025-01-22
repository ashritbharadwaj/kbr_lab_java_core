package org.example.controller;

import org.example.config.AppConfig;
import org.example.dao.Book;
import org.example.service.BookService;
import org.example.service.BookServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService = context.getBean(BookService.class);

        // Use the bookService to perform operations
        System.out.println(bookService.getAllBooks());
    }
}
