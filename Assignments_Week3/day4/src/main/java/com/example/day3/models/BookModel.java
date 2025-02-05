package com.example.day3.models;

import com.example.day3.repo.Book;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.hateoas.RepresentationModel;

public class BookModel extends RepresentationModel<BookModel> {
    private int id;
    private String isbn;
    private String title;
    private String author;

    public BookModel(Book book) {
        this.id = book.getId();
        this.isbn = book.getIsbn();
        this.title = book.getTitle();
        this.author = book.getAuthor();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
