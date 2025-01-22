package org.example.service;

import org.example.dao.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id, Book book);
    public Book getBookById(int id);
}

