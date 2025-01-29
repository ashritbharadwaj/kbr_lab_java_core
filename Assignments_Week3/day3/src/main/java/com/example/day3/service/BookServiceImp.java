package com.example.day3.service;

import com.example.day3.exceptions.BookNotFoundException;
import com.example.day3.repo.Book;
import com.example.day3.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    private BookRepo dao;

    @Autowired
    public BookServiceImp(BookRepo dao) {
        this.dao = dao;
    }

    public void setDao(BookRepo dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public Book updateBook(int id, Book book) {
        return dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        Book book = dao.getBookById(id);
        if(book==null){
            throw new BookNotFoundException("Book with id "+id+" not found");
        }
        return book;
    }
}
