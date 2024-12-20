package com.platzi.Market.persistence.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PurchaseProductPkEntity implements Serializable {

    @Column(name = "id_purchase")
    private Long idPurchase;

    @Column(name = "id_product")
    private Long idProduct;
}
