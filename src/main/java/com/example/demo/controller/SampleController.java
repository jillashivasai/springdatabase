package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.SampleTable;
import com.example.demo.service.SampleService;

@CrossOrigin
@RestController
public class SampleController {
	
    @Autowired
    private SampleService sampleService;

    @PostMapping("/sample/data")
    public String addData(@RequestBody SampleTable sampleTable) {
        sampleService.addData(sampleTable);
        return "Created";
    }

    @GetMapping("/sample/allusers")
  
    public List<SampleTable> getAlList(){
    	return sampleService.getAllData();
    }
       
    @DeleteMapping("/sample/delete")
    public void deleteAllusers() {
        sampleService.deleteAllData();
    }
    
    @GetMapping("/sample/user")
    public ResponseEntity<String> getUserByNameAndPassword(@RequestParam String name, @RequestParam String password) {
        SampleTable user = sampleService.getUserCredentials(name, password);
        if (user != null) {
            return ResponseEntity.ok("User found");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
