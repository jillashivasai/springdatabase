package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SampleTable;
import com.example.demo.repository.SamapleRepo;

@Service
public class SampleService {

    @Autowired
    private SamapleRepo samapleRepo;

    public String addData(SampleTable sampletable) {
        samapleRepo.save(sampletable);
        return "Sample data created";
    }

    public List<SampleTable> getAllData() {
        return samapleRepo.findAll();
    }
//    public SampleTable getUserByNameAndPassword(SampleTable name, SampleTable password) {
//        return samapleRepo.findByNameAndPassword(name, password);
//    }
    public  void  deleteAllData() {
        samapleRepo.deleteAll();
    }
    


    
       public SampleTable getUserCredentials(String name, String password) {
        SampleTable user = samapleRepo.findByNameAndPassword(name, password);
        if (user != null) {
            // User found, handle accordingly
            String username = user.getName();
            String userPassword = user.getPassword();
            // Do something with username and password
        }
		return user; 
		}

//	public SampleTable getUserByNameAndPassword1(SampleTable name, SampleTable password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
