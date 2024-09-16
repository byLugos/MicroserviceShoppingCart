package com.cart.cart.infraestructure.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ElementCollection
    @CollectionTable(name = "cart_articles", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyColumn(name = "article_id")
    @Column(name = "quantity")
    private Map<String, Integer> articles = new HashMap<>();

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "actualization_date", nullable = false)
    private LocalDate actualizationDate;
}