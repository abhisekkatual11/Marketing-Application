package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepositories;

@Service
public class LeadServiceImpl implements LeadService {
	@Autowired
	private LeadRepositories leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public List<Lead> listAll() {
		List<Lead> all = leadRepo.findAll();
		return all;
	}

	@Override
	public Lead updateLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteById(long id) {
		leadRepo.deleteById(id);
	}

}
