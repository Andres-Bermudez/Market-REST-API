package com.platzi.Market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchaseProductPK implements Serializable {

    @Column(name = "id_purchase")
    private Long idPurchase;

    @Column(name = "id_product")
    private Long idProduct;
}
