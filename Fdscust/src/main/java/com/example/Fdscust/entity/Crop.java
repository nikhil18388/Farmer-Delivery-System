package com.example.Fdscust.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Crop {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameofCrop;
    private String quantity;
    private String priceperkg;
    private String pesticidesused;
    private String video;

    public String getNameofCrop() {
        return nameofCrop;
    }

    public void setNameofCrop(String nameofCrop) {
        this.nameofCrop = nameofCrop;
    }

    public String getQuantity() {
        return quantity;
    }

    public Crop(Long id,String nameofCrop, String quantity, String priceperkg, String pesticidesused, String video) {
        this.nameofCrop = nameofCrop;
        this.quantity = quantity;
        this.priceperkg = priceperkg;
        this.pesticidesused = pesticidesused;
        this.video = video;
        this.id=id;
    }

    public Crop() {
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPriceperkg() {
        return priceperkg;
    }

    public void setPriceperkg(String priceperkg) {
        this.priceperkg = priceperkg;
    }

    public String getPesticidesused() {
        return pesticidesused;
    }

    public void setPesticidesused(String pesticidesused) {
        this.pesticidesused = pesticidesused;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
