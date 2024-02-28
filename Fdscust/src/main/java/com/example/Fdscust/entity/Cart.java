package com.example.Fdscust.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cart_items;
    private String confirmOrder;

    public Cart() {
    }

    public Cart(Long id, String cart_items, String confirmOrder) {
        this.id = id;
        this.cart_items = cart_items;
        this.confirmOrder = confirmOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCart_items() {
        return cart_items;
    }

    public void setCart_items(String cart_items) {
        this.cart_items = cart_items;
    }

    public String getConfirmOrder() {
        return confirmOrder;
    }

    public void setConfirmOrder(String confirmOrder) {
        this.confirmOrder = confirmOrder;
    }
}