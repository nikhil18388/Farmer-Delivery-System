package com.example.Fdscust.controller;

import com.example.Fdscust.entity.Crop;
import com.example.Fdscust.entity.Crop;
import com.example.Fdscust.custrepo.CropRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
public class CropController {
    @Autowired
    CropRepo cropRepo;

    @PostMapping("/crops")
    //to below method is invoked
    public ResponseEntity<Crop> savecrop(@RequestBody Crop crop) {
        //requestbody will make the field mandatory
        return new ResponseEntity<>(cropRepo.save(crop), HttpStatus.CREATED);
    }
    @GetMapping("/crops")
    public ResponseEntity<List<Crop>> getcrop(){
        return new ResponseEntity<>(cropRepo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/crops/{id}")
    public ResponseEntity<Crop> getcrop(@PathVariable long id){
        Optional<Crop> crop = cropRepo.findById(id);
        if(crop.isPresent()){
            return  new ResponseEntity<>(crop.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/crops/{id}")
    public ResponseEntity<Crop> updatecrops(@PathVariable long id,@RequestBody Crop crops ){
        Optional<Crop> crop = cropRepo.findById(id);
        //optonal class imported from java util
        if(crop.isPresent()){
//            crop.get().setId(crops.getId());
            crop.get().setNameofCrop(crops.getNameofCrop());
            crop.get().setQuantity(crops.getQuantity());
            crop.get().setPriceperkg(crops.getPriceperkg());
            crop.get().setPesticidesused(crops.getPesticidesused());
            crop.get().setVideo(crops.getVideo());
            return  new ResponseEntity<>(cropRepo.save(crop.get()),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/crops/{id}")
    public ResponseEntity<Void> deletecrops(@PathVariable long id){
        Optional<Crop> crop = cropRepo.findById(id);
        if(crop.isPresent()){
            cropRepo.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
//            System.out.println("invalid id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
