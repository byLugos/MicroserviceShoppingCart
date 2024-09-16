package com.cart.cart.application.handler;
import com.cart.cart.application.dto.request.CartRequestDTO;
import com.cart.cart.application.dto.request.PurchaseRequestDTO;
import com.cart.cart.domain.model.Cart;
import com.cart.cart.domain.ports.api.CartIn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
@Transactional
public class CartHandler {
    private final CartIn cartService;
    public boolean addArticleToCart(CartRequestDTO cartRequestDTO) {
        return cartService.addArticle(
                cartRequestDTO.getIdCart(),
                cartRequestDTO.getIdArticle(),
                cartRequestDTO.getQuantity(),
                cartRequestDTO.getIdUser()
        );
    }
    public Cart createCart(Cart cart) {
        return cartService.createCart(cart);
    }
    public boolean deleteArticleFromCart(CartRequestDTO cartRequestDTO) {
        return cartService.deleteArticle(
                cartRequestDTO.getIdCart(),
                cartRequestDTO.getIdArticle(),
                cartRequestDTO.getIdUser()
        );
    }
    public boolean purchaseCart(PurchaseRequestDTO purchaseRequestDTO) {
        return cartService.buy(
                purchaseRequestDTO.getIdCart(),
                purchaseRequestDTO.getIdUser()
        );
    }
}