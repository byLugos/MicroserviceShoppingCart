package com.cart.cart.domain.exceptions;

public class InvalidArticleNotFound extends RuntimeException{
    public InvalidArticleNotFound(String message) {
        super(message);
    }
}
