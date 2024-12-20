package com.platzi.Market.domain.entities;

public class ProductDomain {

    private Long productId;
    private String name;
    private CategoryDomain categoryDomain;
    private double salesPrice;
    private int stockQuantity;
    private Boolean active;


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
        return categoryDomain;
    }

    public void setCategoryDomain(CategoryDomain categoryDomain) {
        this.categoryDomain = categoryDomain;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
