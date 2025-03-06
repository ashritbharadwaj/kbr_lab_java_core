package com.productstore.order.controller;

import com.productstore.order.dto.ErrorDetailsDTO;
import com.productstore.order.exceptions.OrderCannotCreatedException;
import com.productstore.order.exceptions.OrderNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDetailsDTO> handleOrderNotFoundException(OrderNotFoundException ex) {
//        return ErrorDetailsDTO.builder().timestamp(System.currentTimeMillis()).message(ex.getMessage()).build();
        ErrorDetailsDTO errorDetailsDTO = ErrorDetailsDTO.builder()
                .timestamp(LocalDateTime.now())
                .errorMessage(ex.getMessage())
                .errorCode(404)
                .toContact("OrderNotFoundSupport")
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetailsDTO);
    }

    @ExceptionHandler(OrderCannotCreatedException.class)
    public ResponseEntity<ErrorDetailsDTO> handleOrderCannotCreatedException(OrderCannotCreatedException ex) {
        ErrorDetailsDTO errorDetailsDTO = ErrorDetailsDTO.builder()
                .timestamp(LocalDateTime.now())
                .errorMessage(ex.getMessage())
                .errorCode(400)
                .toContact("OrderCannotCreatedSupport")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetailsDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetailsDTO> handle400(MethodArgumentNotValidException ex){
        String errorMessage= ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ErrorDetailsDTO errorDetails=
                ErrorDetailsDTO.builder().errorCode(400)
                        .timestamp(java.time.LocalDateTime.now())
                        .toContact("MethodArgumentNotValidExceptionSupport")
                        .errorMessage(errorMessage).build();

        return ResponseEntity.badRequest().body(errorDetails);
    }
}
