package com.example.day3.controller;

import com.example.day3.assembler.BookModelAssembler;
import com.example.day3.config.WelcomeConfig;
import com.example.day3.models.BookModel;
import com.example.day3.repo.Book;
import com.example.day3.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;

    @Autowired
    private WelcomeConfig welcomeConfig;

    @Autowired
    private BookModelAssembler bookModelAssembler;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeConfig.getWelcomeMessage();
    }

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBookById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addBook(book));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(service.updateBook(id, book));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        service.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



//    @GetMapping("/booksmodel")
//    public CollectionModel<BookModel> getAllBooks() {
//        List<Book> books = service.getAllBooks();
//        List<BookModel> bookModels = books.stream()
//                .map(bookModelAssembler::toModel)
//                .collect(Collectors.toList());
//        return CollectionModel.of(bookModels, linkTo(methodOn(BookController.class).getAllBooks()).withSelfRel());
//    }
//
//    @GetMapping("/booksmodel/{id}")
//    public EntityModel<BookModel> getBookById(@PathVariable int id) {
//        Book book = service.getBookById(id);
//        return EntityModel.of(bookModelAssembler.toModel(book));
//    }

}
