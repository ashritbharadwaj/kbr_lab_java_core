package org.example.web;

import org.example.dao.BookDaoImpl;
import org.example.dao.DaoException;
import org.example.dto.Book;
import org.example.service.DBserver;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, DaoException {
        System.out.println("Hello world!");
        BookDaoImpl bookDao = new BookDaoImpl();
        DBserver dbserver = new DBserver();
        System.out.println(dbserver.addBook(new Book("2000","GOT","Hampman",500)));
        System.out.println(dbserver.getAllBooks());
        System.out.println(dbserver.addBook(new Book("1234", "Mahabharatha", "Vyasa", 10000.0)));
        System.out.println(dbserver.addBook(new Book("1235", "Ramayana", "Valmiki", 5000.0)));
        System.out.println(dbserver.getAllBooks());
        dbserver.deleteBook(1);
        System.out.println(dbserver.getAllBooks());
        dbserver.updateBook(2, new Book("1234", "Mahabharatha", "Vyasa", 11000.0));
        System.out.println(dbserver.getAllBooks());
        System.out.println(dbserver.getBookById(3));
    }
}
