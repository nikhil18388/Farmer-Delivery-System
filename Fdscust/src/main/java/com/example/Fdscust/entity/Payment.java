package com.example.Fdscust.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Payment {



    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    private String paymenttype;
    private String upi;
    private String card;
    private String netbanking;
    private String cod;
    private String confirmpayment;
    private String orderconfirmed;






    public Payment(Long id,String paymenttype, String upi, String card, String netbanking, String cod, String confirmpayment, String orderconfirmed) {
        this.paymenttype = paymenttype;
        this.id=id;
        this.upi = upi;
        this.card = card;
        this.netbanking = netbanking;
        this.cod = cod;
        this.confirmpayment = confirmpayment;
        this.orderconfirmed = orderconfirmed;
    }

    public Payment() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getNetbanking() {
        return netbanking;
    }

    public void setNetbanking(String netbanking) {
        this.netbanking = netbanking;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getConfirmpayment() {
        return confirmpayment;
    }

    public void setConfirmpayment(String confirmpayment) {
        this.confirmpayment = confirmpayment;
    }

    public String getOrderconfirmed() {
        return orderconfirmed;
    }

    public void setOrderconfirmed(String orderconfirmed) {
        this.orderconfirmed = orderconfirmed;
    }
}
