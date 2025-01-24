package org.example.service;

import org.example.annotations.Loggable;
import org.example.dao.Book;
import org.example.dao.BookDao;
import org.example.dao.BookDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "bookService")
@Transactional
public  class BookServiceImp implements BookService {

    private BookDao dao;

    public BookServiceImp(BookDao dao) {
        this.dao = dao;
    }

    @Autowired
    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    @Loggable
    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    @Loggable
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }
}

