package com.platzi.Market.domain.dto.productdto;

public record ProductReceivedDTO(
        String name,
        Long idCategory,
        String barCode,
        Double salesPrice,
        Long stockQuantity
) {
}
