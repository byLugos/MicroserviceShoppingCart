package com.cart.cart.domain.ports.spi;
import com.cart.cart.domain.model.Cart;
import java.util.Optional;
public interface CartOut {
    Cart save(Cart cart);
    boolean articleExistsById(Long id);
    Optional<Cart>existsById(Long id);
}
