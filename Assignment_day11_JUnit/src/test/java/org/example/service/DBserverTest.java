package org.example.service;

import org.example.dao.BookDao;
import org.example.dao.DaoException;
import org.example.dto.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DBserverTest {

    @Mock
    BookDao bookDao;

    @InjectMocks
    DBserver dbserver;

    @BeforeEach
    void setUp() throws SQLException, DaoException {
        List<Book> books = List.of(new Book[]{new Book("1234", "Mahabharatha", "Vyasa", 10000.0), new Book("1235", "Ramayana", "Valmiki", 5000.0)});
        when(bookDao.getAllBooks()).thenReturn(books);
        when(bookDao.addBook(new Book("1234", "Mahabharatha", "Vyasa", 10000.0))).thenReturn(new Book("1234", "Mahabharatha", "Vyasa", 10000.0));
        when(bookDao.getBookById(1)).thenThrow(DaoException.class);
        doThrow(new DaoException("Error Deleting Book", new SQLException())).when(bookDao).deleteBook(1);
        
    }

    @Test
    void addBookTest() throws DaoException {
        assertEquals(new Book("1234", "Mahabharatha", "Vyasa", 10000.0), dbserver.addBook(new Book("1234", "Mahabharatha", "Vyasa", 10000.0)));
    }

    @Test
    void deleteBook() {
        assertThrowsExactly(DaoException.class, () -> dbserver.deleteBook(1));
    }

    @Test
    void updateBook() {
    }

    @Test
    void getBookByIdTest() {
        assertThrowsExactly(DaoException.class, () -> dbserver.getBookById(1));
    }

    @Test
    void getAllBooksTest() throws SQLException, DaoException {
        assertEquals(2, dbserver.getAllBooks().size());
    }
}