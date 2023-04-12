package com.marketing.services;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {

	public void saveLead(Lead lead);

	public List<Lead> listAll();

	public  Lead updateLead(long id);

	public void deleteById(long id);
	
}
