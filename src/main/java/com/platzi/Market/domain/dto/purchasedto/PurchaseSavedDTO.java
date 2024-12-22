package com.platzi.Market.domain.dto.purchasedto;

import java.time.LocalDateTime;
import com.platzi.Market.persistence.entities.PurchaseEntity;

public record PurchaseSavedDTO(
        Long idPurchase,
        LocalDateTime date,
        String customer,
        String productsList,
        Long total,
        String paymentMethod
) {
    public PurchaseSavedDTO(PurchaseEntity purchaseEntity) {
        this(purchaseEntity.getIdPurchase(),
                purchaseEntity.getDate(),
                purchaseEntity.getIdCustomer(),
                purchaseEntity.getProductsList(),
                purchaseEntity.getTotal(),
                purchaseEntity.getPaymentMethod());
    }
}
