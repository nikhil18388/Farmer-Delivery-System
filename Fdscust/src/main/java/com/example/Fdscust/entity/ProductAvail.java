package com.example.Fdscust.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductAvail {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        private String productName;
        private String rating;
        private String priceperKg;
        private String imageofProduct;
        private String addedtoCart;




    public ProductAvail(Long id, String productName, String rating, String priceperKg, String imageofProduct, String addedtoCart) {
        this.id = id;
        this.productName = productName;
        this.rating = rating;
        this.priceperKg = priceperKg;
        this.imageofProduct = imageofProduct;
        this.addedtoCart = addedtoCart;
    }

    public ProductAvail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPriceperKg() {
        return priceperKg;
    }

    public void setPriceperKg(String priceperKg) {
        this.priceperKg = priceperKg;
    }

    public String getImageofProduct() {
        return imageofProduct;
    }

    public void setImageofProduct(String imageofProduct) {
        this.imageofProduct = imageofProduct;
    }

    public String getAddedtoCart() {
        return addedtoCart;
    }

    public void setAddedtoCart(String addedtoCart) {
        this.addedtoCart = addedtoCart;
    }
}
