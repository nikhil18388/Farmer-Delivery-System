package com.example.Fdscust.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "c_id")
    private Long id;
    private String cname;
    private String cemail;
    private String cphoneno;
    private String caddress;
    private String cpassword;



//@OneToMany(cascade = CascadeType.ALL)
//@JoinColumn(name = "fk_payment",referencedColumnName = "c_id")
//    private List<Payment> payment;



    public Customer(Long id, String cname, String cemail, String cphoneno, String caddress, String cpassword) {
        this.id = id;
        this.cname = cname;
        this.cemail = cemail;
        this.cphoneno = cphoneno;
        this.caddress = caddress;
        this.cpassword = cpassword;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCphoneno() {
        return cphoneno;
    }

    public void setCphoneno(String cphoneno) {
        this.cphoneno = cphoneno;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
}
