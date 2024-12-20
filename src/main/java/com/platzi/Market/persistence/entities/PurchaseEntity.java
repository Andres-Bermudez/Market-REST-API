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

    // Creacion de la relacion de muchos a uno entre dos tablas.
    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    private LocalDateTime date;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String comment;
    private String status;

    // Getters and Setters

    public Long getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Long idPurchase) {
        this.idPurchase = idPurchase;
    }

    public CustomerEntity getCustomer() {
        return customerEntity;
    }

    public void setCustomer(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
