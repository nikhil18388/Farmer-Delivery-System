package com.example.Fdscust.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String farmerName;
    private String farmerEmail;
    private String farmerPhoneno;
    private String farmerAddress;
    private String farmerCrops;
    private String farmerPassword;




    public Farmer() {
        super();
    }

    public Farmer(long id, String farmerName, String farmerEmail, String farmerPhoneno, String farmerAddress, String farmerCrops, String farmerPassword) {
        this.id = id;
        this.farmerName = farmerName;
        this.farmerEmail = farmerEmail;
        this.farmerPhoneno = farmerPhoneno;
        this.farmerAddress = farmerAddress;
        this.farmerCrops = farmerCrops;
        this.farmerPassword = farmerPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public String getFarmerPhoneno() {
        return farmerPhoneno;
    }

    public void setFarmerPhoneno(String farmerPhoneno) {
        this.farmerPhoneno = farmerPhoneno;
    }

    public String getFarmerAddress() {
        return farmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    public String getFarmerCrops() {
        return farmerCrops;
    }

    public void setFarmerCrops(String farmerCrops) {
        this.farmerCrops = farmerCrops;
    }

    public String getFarmerPassword() {
        return farmerPassword;
    }

    public void setFarmerPassword(String farmerPassword) {
        this.farmerPassword = farmerPassword;
    }

//    @Override
//    public String toString() {
//        return "Farmer{" +
//                "id=" + id +
//                ", farmerName='" + farmerName + '\'' +
//                ", farmerEmail='" + farmerEmail + '\'' +
//                ", farmerPhoneno='" + farmerPhoneno + '\'' +
//                ", farmerAddress='" + farmerAddress + '\'' +
//                ", farmerCrops='" + farmerCrops + '\'' +
//                ", farmerPassword='" + farmerPassword + '\'' +
//                '}';
    //   }
}
