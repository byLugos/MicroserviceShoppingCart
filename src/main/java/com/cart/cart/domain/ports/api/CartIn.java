package com.cart.cart.domain.ports.api;


import com.cart.cart.domain.model.Cart;

public interface CartIn {

    Cart createCart(Cart cart);
    boolean addArticle(Long idCart, Long idArticle, int quantity, Long idUser );
    boolean deleteArticle(Long idCart, Long idArticle, Long idUser);
    boolean buy(Long idCart, Long userId);
}
