package com.bookapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorDto {
    private long timestamp;
    private List<String> messages;
}