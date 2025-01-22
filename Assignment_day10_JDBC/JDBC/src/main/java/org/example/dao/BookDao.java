package org.example.dao;

import org.example.dto.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> getAllBooks() throws DaoException, SQLException;
    Book addBook(Book book) throws DaoException;
    void deleteBook(int id) throws DaoException;
    void updateBook(int id, Book book) throws DaoException;
    Book getBookById(int id) throws DaoException;
}
