package com.cart.cart.application.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartRequestDTO {
    private Long idCart;
    private Long idArticle;
    private int quantity;
    private Long idUser;
}
