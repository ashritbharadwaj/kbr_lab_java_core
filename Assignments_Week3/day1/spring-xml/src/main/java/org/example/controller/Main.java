package org.example.controller;

import org.example.dao.Book;
import org.example.service.BookService;
import org.example.service.BookServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println(bookService.getAllBooks());
    }
}
