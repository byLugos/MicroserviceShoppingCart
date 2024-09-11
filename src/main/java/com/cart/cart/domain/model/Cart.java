package com.cart.cart.domain.model;

import java.time.LocalDate;
import java.util.Map;
public class Cart {
    private Long id;
    private Long idUser;
    private Map<String,Integer> articles;
    private LocalDate creationDate;
    private LocalDate actualizationDate;
    public Cart(Long id, Long idUser, Map<String, Integer> articles, LocalDate creationDate, LocalDate actualizationDate) {
        this.id = id;
        this.idUser = idUser;
        this.articles = articles;
        this.creationDate = creationDate;
        this.actualizationDate = actualizationDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public Map<String, Integer> getArticles() {
        return articles;
    }
    public void setArticles(Map<String, Integer> articles) {
        this.articles = articles;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDate getActualizationDate() {
        return actualizationDate;
    }
    public void setActualizationDate(LocalDate actualizationDate) {
        this.actualizationDate = actualizationDate;
    }
}
