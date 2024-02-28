package com.example.Fdscust.controller;

import com.example.Fdscust.entity.Cart;
import com.example.Fdscust.custrepo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//package com.example.Fdscust.controller;
//import com.example.Fdscust.entity.Customer;
//import com.example.Fdscust.custrepo.CustomerRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//import java.util.Optional;


@RestController
public class CartController {
    @Autowired
    CartRepo cartRepo;

    @PostMapping("/carts")
    //to below method is invoked
    public ResponseEntity<Cart> savecart(@RequestBody Cart cart) {
        //requestbody will make the field mandatory
        return new ResponseEntity<>(cartRepo.save(cart), HttpStatus.CREATED);
    }
    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getcart(){
        return new ResponseEntity<>(cartRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/carts/{id}")
    public ResponseEntity<Cart> getcart(@PathVariable long id){
        Optional<Cart> cart = cartRepo.findById(id);
        if(cart.isPresent()){
            return  new ResponseEntity<>(cart.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/carts/{id}")
    public ResponseEntity<Cart> updatecart(@PathVariable long id,@RequestBody Cart cartt ){
        Optional<Cart> cart = cartRepo.findById(id);
        //optonal class imported from java util
        if(cart.isPresent()){
            cart.get().setCart_items(cartt.getCart_items());
            cart.get().setId(cartt.getId());
            cart.get().setConfirmOrder(cartt.getConfirmOrder());
            return  new ResponseEntity<>(cartRepo.save(cart.get()),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Void> deletecart(@PathVariable long id){
        Optional<Cart> cart = cartRepo.findById(id);
        if(cart.isPresent()){
            cartRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
//            System.out.println("invalid id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}