package com.example.Fdscust.controller;

import com.example.Fdscust.custrepo.CustomerRepo;
import com.example.Fdscust.entity.Customer;
import com.example.Fdscust.entity.Farmer;
import com.example.Fdscust.custrepo.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/customers")
    //to below method is invoked
    public ResponseEntity<Customer> savecustomer(@RequestBody Customer cust) {
        //requestbody will make the field mandatory
        return new ResponseEntity<>(customerRepo.save(cust), HttpStatus.CREATED);

    }
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getcustomers(){
        return new ResponseEntity<>(customerRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getcustomers(@PathVariable long id){
        Optional<Customer> obj = customerRepo.findById(id);
        if(obj.isPresent()){
            return  new ResponseEntity<>(obj.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updatecustomers(@PathVariable long id,@RequestBody Customer cust ){
        Optional<Customer> customer = customerRepo.findById(id);
        //optonal class imported from java util
        if(customer.isPresent()){
            customer.get().setCname(cust.getCname());
            customer.get().setCpassword(cust.getCpassword());
            customer.get().setCaddress(cust.getCaddress());
            customer.get().setCemail(cust.getCemail());
            customer.get().setCpassword(cust.getCpassword());
            return  new ResponseEntity<>(customerRepo.save(customer.get()),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deletecustomer(@PathVariable long id){
        Optional<Customer> custom = customerRepo.findById(id);
        if(custom.isPresent()){
            customerRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
//            System.out.println("invalid id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}