package org.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoImp implements BookDao {
    private Map<Integer, Book> booksMap;
    private int counter;

    // Setters for DI
    public void setBooksMap(Map<Integer, Book> booksMap) {
        this.booksMap = booksMap;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(booksMap.values());
    }

    @Override
    public Book addBook(Book book) {
        book.setId(++counter);
        booksMap.put(counter, book);
        return booksMap.get(counter);
    }

    @Override
    public void deleteBook(int id) {
        booksMap.remove(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        booksMap.put(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return booksMap.get(id);
    }

}

