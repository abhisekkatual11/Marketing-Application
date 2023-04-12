package com.marketing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepositories;

@RestController
//http://localhost:8080/api/lead
@RequestMapping("/api/lead")
public class LeadRestController {
	
	@Autowired
	private LeadRepositories leadRepo;
	
	@GetMapping
	public List<Lead> getAll(){
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}
	
	//http://localhost:8080/api/lead/getId/12
	@RequestMapping("/getId/{id}")
	public Lead getId(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	
	@PostMapping
	public void saveLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/lead/deleteId/13
	@DeleteMapping("/deleteId/{id}")
	public void deleteLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
	//http://localhost:8080/api/lead/update/1
	@PutMapping("/update/{id}")
	public void updateLead(@PathVariable("id") long id,Lead lead){
		leadRepo.save(lead);
	}
}
