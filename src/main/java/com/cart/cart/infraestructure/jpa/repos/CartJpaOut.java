package com.cart.cart.infraestructure.jpa.repos;

import com.cart.cart.domain.model.Cart;
import com.cart.cart.domain.ports.spi.CartOut;
import com.cart.cart.infraestructure.jpa.entity.CartEntity;
import com.cart.cart.infraestructure.jpa.mapper.CartJpaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CartJpaOut implements CartOut {
    private final CartRepository cartRepository;
    private final CartJpaMapper cartJpaMapper;
    @Override
    public Cart save(Cart cart) {
        CartEntity cartEntity = cartJpaMapper.toEntity(cart);
        CartEntity savedEntity = cartRepository.save(cartEntity);
        return cartJpaMapper.toDomain(savedEntity);
    }

    @Override
    public boolean articleExistsById(Long id) {
        // Este método debería interactuar con otro microservicio, pero aquí simplemente devolvemos true como placeholder.
        return true;
    }

    @Override
    public Optional<Cart> existsById(Long id) {
        Optional<CartEntity> cartEntityOptional = cartRepository.findById(id);
        return cartEntityOptional.map(cartJpaMapper::toDomain);
    }
}
