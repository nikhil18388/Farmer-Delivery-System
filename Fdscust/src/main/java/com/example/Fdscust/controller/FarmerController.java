package com.example.Fdscust.controller;

import com.example.Fdscust.entity.Farmer;
import com.example.Fdscust.custrepo.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
public class FarmerController {
    @Autowired
    FarmerRepo farmerRepo;

    @PostMapping("/farmers")
    //to below method is invoked
    public ResponseEntity<Farmer> savefarmers(@RequestBody Farmer farmer) {
        //requestbody will make the field mandatory
        return new ResponseEntity<>(farmerRepo.save(farmer), HttpStatus.CREATED);

    }
    @GetMapping("/farmers")
    public ResponseEntity<List<Farmer>> getfarmers(){
        return new ResponseEntity<>(farmerRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/farmers/{id}")
    public ResponseEntity<Farmer> getfarmers(@PathVariable long id){
        Optional<Farmer> farmer = farmerRepo.findById(id);
        if(farmer.isPresent()){
            return  new ResponseEntity<>(farmer.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/farmers/{id}")
    public ResponseEntity<Farmer> updatefarmer(@PathVariable long id,@RequestBody Farmer farm ){
        Optional<Farmer> farmer = farmerRepo.findById(id);
        //optonal class imported from java util
        if(farmer.isPresent()){
            farmer.get().setFarmerName(farm.getFarmerName());
            farmer.get().setFarmerEmail(farm.getFarmerEmail());
            farmer.get().setFarmerAddress(farm.getFarmerAddress());
            return  new ResponseEntity<>(farmerRepo.save(farmer.get()),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/farmers/{id}")
    public ResponseEntity<Void> deletefarmer(@PathVariable long id){
        Optional<Farmer> student = farmerRepo.findById(id);
        if(student.isPresent()){
            farmerRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
//            System.out.println("invalid id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}