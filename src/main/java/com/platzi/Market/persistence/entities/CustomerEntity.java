package com.platzi.Market.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @Column(name = "id_customer")
    private String idCustomer;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String phone;
    private String address;
    private String email;

    public CustomerEntity() {
    }

    public CustomerEntity(String id,
                          String name,
                          String lastName,
                          String phone,
                          String address,
                          String email
    ) {
        this.idCustomer = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    // Getters and Setters.

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
