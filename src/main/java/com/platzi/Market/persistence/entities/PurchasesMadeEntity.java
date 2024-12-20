package com.platzi.Market.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "purchases_made")
public class PurchasesMadeEntity {

    // Como la clave primaria de esta entidad es compuesta, se debe crear un clase aparte que
    // contenga las dos columnas de la clave primaria y anotar esa clase como @Embeddable e
    // implementar la interfaz "Seriarizable" y en esta clase se debe crear una instancia de
    // la clave primaria y anotarla con @EmbededId.
    @EmbeddedId
    private PurchaseProductPkEntity id;

    // Creacion de la relacion de muchos a uno entre dos tablas.
    @ManyToOne
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    // Creacion de la relacion de muchos a uno entre dos tablas
    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private ProductEntity productEntity;

    private Long quantity;
    private double total;
    private Boolean status;


    // Getters and Setters

    public PurchaseProductPkEntity getId() {
        return id;
    }

    public void setId(PurchaseProductPkEntity id) {
        this.id = id;
    }

    public PurchaseEntity getPurchaseEntity() {
        return purchaseEntity;
    }

    public void setPurchaseEntity(PurchaseEntity purchaseEntity) {
        this.purchaseEntity = purchaseEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}