package com.platzi.Market.persistence.entity;

import jakarta.persistence.Column;

public class Category {

    @Column(name = "id_category")
    private Long idCategory;

    private String description;
    private Boolean status;

    // Getters and Setters

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
