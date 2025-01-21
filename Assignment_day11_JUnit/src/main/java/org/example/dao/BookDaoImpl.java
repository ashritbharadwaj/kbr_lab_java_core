package org.example.dao;

import org.example.dao.dbconnfactory.DBConnFactory;
import org.example.dto.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    Connection connection=null;

    public BookDaoImpl() {
        connection = DBConnFactory.getConnection();
        if(connection!=null) System.out.println("connection established");
    }

    @Override
    public List<Book> getAllBooks() throws DaoException{
        List<Book> books = new ArrayList<>();
        String query = "select * from books";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                Book book = new Book(id, isbn, title, author, price);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching all books",e);
        }

        return books;
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        String query = "INSERT INTO books (isbn, title, author, price) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setDouble(4, book.getPrice());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) book.setId(resultSet.getInt(1));
        }catch (SQLException e) {
            throw new DaoException("Error adding book",e);
        }
        return book;
    }

    @Override
    public void deleteBook(int id) throws DaoException {
        String query = "DELETE FROM books WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException("Error deleting book",e);
        }
    }

    @Override
    public void updateBook(int id, Book book) throws DaoException {
        String query = "UPDATE books SET isbn = ?, title = ?, author = ?, price = ? WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setDouble(4, book.getPrice());
            statement.setInt(5, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException("Error updating book",e);
        }
    }

    @Override
    public Book getBookById(int id) throws DaoException {
        String query = "SELECT * FROM books WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                return new Book(id, isbn, title, author, price);
            }
        }catch (SQLException e) {
            throw new DaoException("Error fetching book by id",e);
        }
        return null;
    }
}
