package org.example.service;

import org.example.dao.BookDao;
import org.example.dao.BookDaoImpl;
import org.example.dao.DaoException;
import org.example.dto.Book;

import java.sql.SQLException;
import java.util.List;

public class DBserver {
    BookDao bookDao = new BookDaoImpl();

    public Book addBook(Book book) throws DaoException {
        return bookDao.addBook(book);
    }

    public void deleteBook(int id) throws DaoException {
        bookDao.deleteBook(id);
    }

    public void updateBook(int id, Book book) throws DaoException {
        bookDao.updateBook(id, book);
    }

    public Book getBookById(int id) throws DaoException {
        return bookDao.getBookById(id);
    }

    public List<Book> getAllBooks() throws DaoException, SQLException {
        return bookDao.getAllBooks();
    }
}
