package com.bankapp.controller;

import com.bankapp.dto.ErrorResponceDto;
import com.bankapp.exceptions.AccountNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(AccountNotFoundException.class)
    private ResponseEntity<ErrorResponceDto> handleAccountNotFoundException(AccountNotFoundException ex) {
        ErrorResponceDto errorResponceDto = ErrorResponceDto.builder()
                .errorMessage(ex.getMessage())
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .timestamp(LocalDateTime.now())
                .toContact("contact@xyz")
                .build();

        return new ResponseEntity<>(errorResponceDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponceDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).
                collect(Collectors.joining(", "));

        ErrorResponceDto errorResponceDto = ErrorResponceDto.builder()
                .errorMessage(errorMessage)
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .timestamp(LocalDateTime.now())
                .toContact("contact@abc")
                .build();

        return new ResponseEntity<>(errorResponceDto, HttpStatus.BAD_REQUEST);
    }


}
