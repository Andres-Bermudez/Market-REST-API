package com.platzi.Market.domain.entities;

public class ProductDomain {

    private Long productId;
    private String name;
    private CategoryDomain category;
    private double salesPrice;
    private Long stockQuantity;
    private Boolean status;

    public ProductDomain() {
    }

    // Getters and Setters.

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDomain getCategoryDomain() {
        return category;
    }

    public void setCategoryDomain(CategoryDomain categoryDomain) {
        this.category = categoryDomain;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setStockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
