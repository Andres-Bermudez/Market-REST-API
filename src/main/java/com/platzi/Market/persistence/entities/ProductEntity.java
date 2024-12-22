package com.platzi.Market.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    private String name;

    // Creacion de la relacion muchos a uno entre dos tablas.
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "sales_price")
    private Double salesPrice;

    @Column(name = "stock_quantity")
    private Long stockQuantity;

    private Boolean status;


    public ProductEntity() {
    }

    public ProductEntity(Long idProduct,
                         String name,
                         CategoryEntity categoryEntity,
                         String barCode,
                         Double salesPrice,
                         Long stockQuantity
    ) {
        this.idProduct = idProduct;
        this.name = name;
        this.categoryEntity = categoryEntity;
        this.barCode = barCode;
        this.salesPrice = salesPrice;
        this.stockQuantity = stockQuantity;
        this.status = true;
    }

    // Getters and Setters.

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
