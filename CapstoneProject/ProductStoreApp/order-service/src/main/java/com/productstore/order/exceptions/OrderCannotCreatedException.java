package com.productstore.order.exceptions;

public class OrderCannotCreatedException extends RuntimeException {
    public OrderCannotCreatedException(String message) {
        super(message);
    }
}
