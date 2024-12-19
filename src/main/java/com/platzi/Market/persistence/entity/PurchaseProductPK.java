package com.platzi.Market.persistence.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PurchaseProductPK implements Serializable {

    @Column(name = "id_purchase")
    private Long idPurchase;

    @Column(name = "id_product")
    private Long idProduct;
}
