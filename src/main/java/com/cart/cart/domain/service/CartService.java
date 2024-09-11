package com.cart.cart.domain.service;

import com.cart.cart.domain.exceptions.InvalidArticleNotFound;
import com.cart.cart.domain.exceptions.InvalidCartNotFound;
import com.cart.cart.domain.exceptions.InvalidOwnerCart;
import com.cart.cart.domain.model.Cart;
import com.cart.cart.domain.ports.api.CartIn;
import com.cart.cart.domain.ports.spi.CartOut;
import com.cart.cart.domain.utils.Constants;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class CartService implements CartIn {
    private final CartOut cartOut;
    public CartService(CartOut cartOut) {
        this.cartOut = cartOut;
    }
    @Override
    public Cart createCart(Cart cart) {
        return cartOut.save(cart);
    }
    @Override
    public boolean addArticle(Long idCart, Long idArticle, int quantity, Long idUser) {
        Optional<Cart> cartOptional = cartOut.existsById(idCart);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            if (!cart.getIdUser().equals(idUser)) {
                throw new InvalidOwnerCart(Constants.USER_NOT_CART_OWNER);
            }
            if (!cartOut.articleExistsById(idArticle)) {
                throw new InvalidArticleNotFound(Constants.ARTICLE_NOT_FOUND);
            }

            Map<String, Integer> articles = cart.getArticles();
            articles.put(idArticle.toString(), articles.getOrDefault(idArticle.toString(), 0) + quantity);
            cart.setArticles(articles);
            cart.setActualizationDate(LocalDate.now());
            cartOut.save(cart);
            return true;
        } else {
            throw new InvalidCartNotFound(Constants.CART_NOT_FOUND);
        }
    }

    @Override
    public boolean deleteArticle(Long idCart, Long idArticle, Long idUser) {
        Optional<Cart> cartOptional = cartOut.existsById(idCart);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            if (!cart.getIdUser().equals(idUser)) {
                throw new InvalidOwnerCart(Constants.USER_NOT_CART_OWNER);
            }

            Map<String, Integer> articles = cart.getArticles();
            if (articles.containsKey(idArticle.toString())) {
                articles.remove(idArticle.toString());
                cart.setArticles(articles);
                cart.setActualizationDate(LocalDate.now());
                cartOut.save(cart);
                return true;
            } else {
                throw new InvalidCartNotFound(Constants.ARTICLE_NOT_FOUND_IN_CART);
            }
        } else {
            throw new InvalidCartNotFound(Constants.CART_NOT_FOUND);
        }
    }

    @Override
    public boolean buy(Long idCart, Long userId) {
        Optional<Cart> cartOptional = cartOut.existsById(idCart);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            return cart.getIdUser().equals(userId);
        }
        throw new InvalidCartNotFound(Constants.CART_NOT_FOUND);
    }
}