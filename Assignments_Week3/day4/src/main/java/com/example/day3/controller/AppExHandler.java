package com.example.day3.controller;

import com.example.day3.exceptions.BookNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class AppExHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handle404(BookNotFoundException ex){
        ErrorDetails errorDetails=
                ErrorDetails.builder().errorCode(404)
                        .timestamp(java.time.LocalDateTime.now())
                        .toContact("Ashrit@koerber.com")
                        .errorMessage(ex.getMessage()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
        String errorMessage= ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ErrorDetails errorDetails=
                ErrorDetails.builder().errorCode(400)
                        .timestamp(java.time.LocalDateTime.now())
                        .toContact("Ashrit@koerber.com")
                        .errorMessage(errorMessage).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
