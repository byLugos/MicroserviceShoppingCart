package com.cart.cart.infraestructure.handlerexceptions;

import com.cart.cart.domain.exceptions.InvalidArticleNotFound;
import com.cart.cart.domain.exceptions.InvalidCartNotFound;
import com.cart.cart.domain.exceptions.InvalidOwnerCart;
import com.cart.cart.infraestructure.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidArticleNotFound.class)
    public ResponseEntity<ErrorResponseCustom> handleInvalidArticleException(InvalidArticleNotFound ex, WebRequest request) {
        ErrorResponseCustom errorResponse = new ErrorResponseCustom(ex.getMessage(), Constants.ARTICLE_NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCartNotFound.class)
    public ResponseEntity<ErrorResponseCustom> handleInvalidCartException(InvalidCartNotFound ex, WebRequest request) {
        ErrorResponseCustom errorResponse = new ErrorResponseCustom(ex.getMessage(), Constants.CART_NOT_FOUND);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidOwnerCart.class)
    public ResponseEntity<ErrorResponseCustom> handleInvalidCartOwner(InvalidOwnerCart ex, WebRequest request) {
        ErrorResponseCustom errorResponse = new ErrorResponseCustom(ex.getMessage(), Constants.USER_NOT_CART_OWNER);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
