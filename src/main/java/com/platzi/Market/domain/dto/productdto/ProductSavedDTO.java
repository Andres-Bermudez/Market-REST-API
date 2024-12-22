package com.platzi.Market.domain.dto.productdto;

import com.platzi.Market.persistence.entities.ProductEntity;
import com.platzi.Market.persistence.entities.CategoryEntity;

public record ProductSavedDTO(
        Long idProduct,
        String name,
        CategoryEntity category,
        Double salesPrice,
        Long stockQuantity
) {
    public ProductSavedDTO(ProductEntity productEntity) {
        this(productEntity.getIdProduct(),
                productEntity.getName(),
                productEntity.getCategoryEntity(),
                productEntity.getSalesPrice(),
                productEntity.getStockQuantity()
        );
    }
}
