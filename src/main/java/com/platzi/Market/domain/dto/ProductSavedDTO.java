package com.platzi.Market.domain.dto;

import com.platzi.Market.persistence.entities.ProductEntity;

public record ProductSavedDTO(
        Long idProduct,
        String name,
        Double salesPrice,
        Long stockQuantity
) {
    public ProductSavedDTO(ProductEntity productEntity) {
        this(productEntity.getIdProduct(),
                productEntity.getName(),
                productEntity.getSalesPrice(),
                productEntity.getStockQuantity()
        );
    }
}
