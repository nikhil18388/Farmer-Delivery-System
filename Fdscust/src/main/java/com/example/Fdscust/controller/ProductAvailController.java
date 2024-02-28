package com.example.Fdscust.controller;

import com.example.Fdscust.entity.ProductAvail;
import com.example.Fdscust.custrepo.ProductAvailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class ProductAvailController {
    @Autowired
    ProductAvailRepo productAvailRepo;

    @PostMapping("/products")
    //to below method is invoked
    public ResponseEntity<ProductAvail> saveproduct(@RequestBody ProductAvail productAvail) {
        //requestbody will make the field mandatory
        return new ResponseEntity<>(productAvailRepo.save(productAvail), HttpStatus.CREATED);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductAvail>> getproduct(){
        return new ResponseEntity<>(productAvailRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductAvail> getproduct(@PathVariable long id){
        Optional<ProductAvail> productAvail = productAvailRepo.findById(id);
        if(productAvail.isPresent()){
            return  new ResponseEntity<>(productAvail.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductAvail> updateproduct(@PathVariable long id,@RequestBody ProductAvail cust ){
        Optional<ProductAvail> productAvail = productAvailRepo.findById(id);
        //optonal class imported from java util
        if(productAvail.isPresent()){
            productAvail.get().setProductName(cust.getProductName());
            productAvail.get().setRating(cust.getRating());
            productAvail.get().setPriceperKg(cust.getPriceperKg());
            productAvail.get().setImageofProduct(cust.getImageofProduct());
            productAvail.get().setAddedtoCart(cust.getAddedtoCart());
            return  new ResponseEntity<>(productAvailRepo.save(productAvail.get()),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteproduct(@PathVariable long id){
        Optional<ProductAvail> productAvail = productAvailRepo.findById(id);
        if(productAvail.isPresent()){
            productAvailRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
//            System.out.println("invalid id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}