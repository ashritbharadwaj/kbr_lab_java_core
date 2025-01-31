package com.bankapp.controller;

import com.bankapp.dto.ErrorMessages;
import com.bankapp.exceptions.AccountNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AccountExceptionController {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleAccountNotFoundException(AccountNotFoundException exception) {
        ErrorMessages errorMessages = new ErrorMessages();
        errorMessages.setTimestamp(LocalDateTime.now());
        errorMessages.setStatus(404);
        errorMessages.setMessage(exception.getMessage());
        errorMessages.setToContact("Please contact the bank for more information.");
        return ResponseEntity.status(404).body(errorMessages);
    }
}
