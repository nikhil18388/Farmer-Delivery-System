package com.example.Fdscust.controller;

import com.example.Fdscust.entity.Login;
import com.example.Fdscust.custrepo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class LoginController {
    @Autowired
    LoginRepo loginRepo;

    @PostMapping("/logins")
    //to below method is invoked
    public ResponseEntity<Login> savelogin(@RequestBody Login login) {
        //requestbody will make the field mandatory
        return new ResponseEntity<>(loginRepo.save(login), HttpStatus.CREATED);
    }
    @GetMapping("/logins")
    public ResponseEntity<List<Login>> getlogin(){
        return new ResponseEntity<>(loginRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/logins/{id}")
    public ResponseEntity<Login> getlogin(@PathVariable long id){
        Optional<Login> login = loginRepo.findById(id);
        if(login.isPresent()){
            return  new ResponseEntity<>(login.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/logins/{id}")
    public ResponseEntity<Login> updatelogin(@PathVariable long id,@RequestBody Login cust ){
        Optional<Login> login = loginRepo.findById(id);
        //optonal class imported from java util
        if(login.isPresent()){
            login.get().setCustomer(cust.getCustomer());
            login.get().setFarmer(cust.getFarmer());
            return  new ResponseEntity<>(loginRepo.save(login.get()),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }




    }
    @DeleteMapping("/logins/{id}")
    public ResponseEntity<Void> deletelogins(@PathVariable long id){
        Optional<Login> login = loginRepo.findById(id);
        if(login.isPresent()){
            loginRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
//            System.out.println("invalid id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}