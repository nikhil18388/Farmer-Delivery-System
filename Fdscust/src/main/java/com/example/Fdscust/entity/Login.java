package com.example.Fdscust.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;
    private String farmer;
    private String customer;



    public Login(Long id,String farmer, String customer) {
        this.farmer = farmer;
        this.id=id;
        this.customer = customer;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Login() {
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}

