package org.example.controller;

//import org.example.config.AppConfig;
//import org.example.dao.Book;
//import org.example.service.BookService;
//import org.example.service.BookServiceImp;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
////        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
////
////        BookService bookService = context.getBean(BookService.class);
////
////        // Use the bookService to perform operations
////        System.out.println(bookService.getAllBooks());
//
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//
//        BookService bookService = (BookService) context.getBean("bsi");
//
//        // Use the bookService to perform operations
//        bookService.deleteBook(1); // This should trigger the logging aspect
//        System.out.println(bookService.getAllBooks());
//    }
//}



import org.example.config.AppConfig;
import org.example.service.BookService;
import org.example.service.BookServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("All Books:");
        bookService.getAllBooks().forEach(System.out::println);


        context.close();
    }
}


//        Book newBook = new Book(0, "9999999999999", "The Pragmatic Programmer", "Andy Hunt", 49.95);
//        Book addedBook = bookService.addBook(newBook);
//        System.out.println("Added Book: " + addedBook);
//
//        Book retrievedBook = bookService.getBookById(addedBook.getId());
//        System.out.println("Retrieved Book by ID: " + retrievedBook);
//
//        retrievedBook.setPrice(54.95);
//        bookService.updateBook(retrievedBook.getId(), retrievedBook);
//        System.out.println("Updated Book: " + bookService.getBookById(retrievedBook.getId()));
//
//        bookService.deleteBook(retrievedBook.getId());
//        System.out.println("Book deleted. All Books:");
//        bookService.getAllBooks().forEach(System.out::println);