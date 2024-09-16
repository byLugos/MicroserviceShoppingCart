package com.cart.cart.infraestructure.jpa.mapper;
import com.cart.cart.domain.model.Cart;
import com.cart.cart.infraestructure.jpa.entity.CartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartJpaMapper {
    default CartEntity toEntity(Cart cart) {
        if (cart == null) return null;
        return new CartEntity(
                cart.getId(),
                cart.getIdUser(),
                cart.getArticles(),
                cart.getCreationDate(),
                cart.getActualizationDate()
        );
    }
    default  Cart toDomain(CartEntity cartEntity) {
        if (cartEntity == null) return null;
        return new Cart(
                cartEntity.getId(),
                cartEntity.getUserId(),
                cartEntity.getArticles(),
                cartEntity.getCreationDate(),
                cartEntity.getActualizationDate()
        );
    }
}
