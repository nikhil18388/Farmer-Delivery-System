package com.example.Fdscust.controller;

import com.example.Fdscust.entity.Payment;
import com.example.Fdscust.custrepo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class PaymentController {
    @Autowired
PaymentRepo paymentRepo;
    @PostMapping("/payments")
    //to below method is invoked
    public ResponseEntity<Payment> savepayment(@RequestBody Payment payment) {
        //requestbody will make the field mandatory
        return new ResponseEntity<>(paymentRepo.save(payment), HttpStatus.CREATED);
    }
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getpayment(){
        return new ResponseEntity<>(paymentRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getpayment(@PathVariable long id){
        Optional<Payment> payment = paymentRepo.findById(id);
        if(payment.isPresent()){
            return  new ResponseEntity<>(payment.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/payments/{id}")
    public ResponseEntity<Payment> updatefarmer(@PathVariable long id,@RequestBody Payment pay ){
        Optional<Payment> payment = paymentRepo.findById(id);
        //optonal class imported from java util
        if(payment.isPresent()){
            payment.get().setId(pay.getId());
            payment.get().setPaymenttype(pay.getPaymenttype());
            payment.get().setUpi(pay.getUpi());
            payment.get().setCard(pay.getCard());
            payment.get().setNetbanking(pay.getNetbanking());
            payment.get().setCod(pay.getCod());
            payment.get().setConfirmpayment(pay.getPaymenttype());
            payment.get().setOrderconfirmed(pay.getOrderconfirmed());
            return  new ResponseEntity<>(paymentRepo.save(payment.get()),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/payments/{id}")
    public ResponseEntity<Void> deletepayment(@PathVariable long id){
        Optional<Payment> payment = paymentRepo.findById(id);
        if(payment.isPresent()){
            paymentRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
//            System.out.println("invalid id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}