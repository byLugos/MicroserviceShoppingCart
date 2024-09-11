package com.cart.cart.infraestructure.controllers;

import com.cart.cart.application.dto.request.CartRequestDTO;
import com.cart.cart.application.dto.request.CreateCartRequestDTO;
import com.cart.cart.application.dto.request.PurchaseRequestDTO;
import com.cart.cart.application.dto.response.CartResponseDTO;
import com.cart.cart.application.handler.CartHandler;
import com.cart.cart.domain.model.Cart;
import com.cart.cart.infraestructure.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartHandler cartHandler;

    public CartController(CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }

    @PostMapping("/addArticle")
    public ResponseEntity<String> addArticleToCart(@RequestBody CartRequestDTO cartRequestDTO) {
        boolean success = cartHandler.addArticleToCart(cartRequestDTO);
        if (success) {
            return ResponseEntity.ok(Constants.ARTICLE_ADDED_SUCCESS);
        } else {
            return ResponseEntity.badRequest().body(Constants.ARTICLE_ADDED_FAILURE);
        }
    }

    @PostMapping("/deleteArticle")
    public ResponseEntity<String> deleteArticleFromCart(@RequestBody CartRequestDTO cartRequestDTO) {
        boolean success = cartHandler.deleteArticleFromCart(cartRequestDTO);
        if (success) {
            return ResponseEntity.ok(Constants.ARTICLE_DELETED_SUCCESS);
        } else {
            return ResponseEntity.badRequest().body(Constants.ARTICLE_DELETED_FAILURE);
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseCart(@RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        boolean success = cartHandler.purchaseCart(purchaseRequestDTO);
        if (success) {
            return ResponseEntity.ok(Constants.PURCHASE_SUCCESS);
        } else {
            return ResponseEntity.badRequest().body(Constants.PURCHASE_FAILURE);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<CartResponseDTO> createCart(@RequestBody CreateCartRequestDTO createCartRequestDTO) {
        Cart newCart = new Cart(null, createCartRequestDTO.getIdUser(), new HashMap<>(), LocalDate.now(), LocalDate.now());
        Cart savedCart = cartHandler.createCart(newCart);
        CartResponseDTO responseDTO = new CartResponseDTO(savedCart.getId(), savedCart.getIdUser(), savedCart.getArticles(), savedCart.getCreationDate(), savedCart.getActualizationDate());
        return ResponseEntity.ok(responseDTO);
    }
}