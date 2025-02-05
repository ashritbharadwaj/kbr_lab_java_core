package com.example.day3.assembler;

import com.example.day3.controller.BookController;
import com.example.day3.models.BookModel;
import com.example.day3.repo.Book;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, BookModel> {

    public BookModelAssembler() {
        super(BookController.class, BookModel.class);
    }

    @Override
    public BookModel toModel(Book book) {
        BookModel bookModel = instantiateModel(book);
        bookModel.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
        bookModel.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
        return bookModel;
    }

    @Override
    protected BookModel instantiateModel(Book book) {
        return new BookModel(book);
    }
}

