package com.example.day3.repo;

import java.util.List;

public interface BookRepo {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(int id);
    public Book updateBook(int id, Book book);
    public Book getBookById(int id);
}
