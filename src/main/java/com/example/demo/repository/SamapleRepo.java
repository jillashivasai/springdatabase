package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SampleTable;

@Repository
public interface SamapleRepo extends JpaRepository<SampleTable, Integer> {
	
	 SampleTable findByNameAndPassword(String name, String password);

	SampleTable findByNameAndPassword(SampleTable name, SampleTable password);
	 
}
