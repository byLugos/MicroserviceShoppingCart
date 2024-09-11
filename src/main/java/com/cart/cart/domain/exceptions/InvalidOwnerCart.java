package com.cart.cart.domain.exceptions;

public class InvalidOwnerCart extends RuntimeException{
    public InvalidOwnerCart(String message) {
        super(message);
    }
}
