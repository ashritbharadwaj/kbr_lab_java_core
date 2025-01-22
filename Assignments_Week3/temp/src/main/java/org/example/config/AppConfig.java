package org.example.config;

import org.example.dao.BookDao;
import org.example.dao.BookDaoImp;
import org.example.service.BookService;
import org.example.service.BookServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookDao bookDao() {
        return new BookDaoImp();
    }

    @Bean
    public BookService bookService() {
        BookServiceImp bookService = new BookServiceImp();
        bookService.setDao(bookDao());
        return bookService;
    }
}
