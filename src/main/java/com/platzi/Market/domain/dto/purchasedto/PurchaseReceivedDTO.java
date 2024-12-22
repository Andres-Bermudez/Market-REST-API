package com.platzi.Market.domain.dto.purchasedto;

public record PurchaseReceivedDTO(
        String idCustomer,
        String productsList,
        String nameCustomer,
        String lastnameCustomer,
        String phoneCustomer,
        String addressCustomer,
        String emailCustomer,
        Long total,
        String paymentMethod
) {
}
