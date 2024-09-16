package com.cart.cart.application.mapper;

import com.cart.cart.application.dto.response.CartResponseDTO;
import com.cart.cart.domain.model.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartResponseDTO toResponseDTO(Cart cart) {
        if (cart == null) return null;
        return new CartResponseDTO(
                cart.getId(),
                cart.getIdUser(),
                cart.getArticles(),
                cart.getCreationDate(),
                cart.getActualizationDate()
        );
    }
}
