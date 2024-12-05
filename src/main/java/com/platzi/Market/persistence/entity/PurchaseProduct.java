package com.platzi.Market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchases_products")
public class PurchaseProduct {

    // Como la clave primaria de esta entidad es compuesta, se debe crear un clase aparte que
    // contenga las dos columnas de la clave primaria y anotar esa clase como @Embeddable e
    // implementar la interfaz "Seriarizable" y en esta clase se debe crear una instancia de
    // la clave primaria y anotarla con @EmbededId.
    @EmbeddedId
    private PurchaseProductPK id;

    private Integer quantity;
    private Double total;
    private Boolean status;

    // Creacion de la relacion de muchos a uno entre dos tablas.
    @ManyToOne
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    private Purchase purchase;

    // Creacion de la relacion de muchos a uno entre dos tablas
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    // Getters and Setters

    public PurchaseProductPK getId() {
        return id;
    }

    public void setId(PurchaseProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
