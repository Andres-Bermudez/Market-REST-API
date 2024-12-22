package com.platzi.Market.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase")
    private Long idPurchase;

    private LocalDateTime date;

    @Column(name = "products_list")
    private String productsList;

    @Column(name = "id_customer")
    private String idCustomer;

    private Long total;

    @Column(name = "payment_method")
    private String paymentMethod;

    public PurchaseEntity() {
    }

    public PurchaseEntity(String idCustomer,
                          String productsList,
                          Long total,
                          String paymentMethod
    ) {
        this.idCustomer = idCustomer;
        this.date = LocalDateTime.now();
        this.productsList = productsList;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }


    // Getters and Setters

    public Long getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Long idPurchase) {
        this.idPurchase = idPurchase;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getProductsList() {
        return productsList;
    }

    public void setProductsList(String productsList) {
        this.productsList = productsList;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
