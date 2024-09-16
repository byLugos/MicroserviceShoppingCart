package com.cart.cart.domain.exceptions;

public class InvalidCartNotFound extends RuntimeException{
    public InvalidCartNotFound(String message) {
        super(message);
    }
}
