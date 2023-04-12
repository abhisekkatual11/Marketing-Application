package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller
public class LeadController {
	//http://localhost:8080/create
	@RequestMapping("/create")
	private String viewCreateLeadForm() {
		return "create_lead";
	}
	
	@Autowired
	private LeadService leadSer;
	
	//http://localhost:8080/save
	@RequestMapping("/save")
	public String saveLead(Lead lead) {
		leadSer.saveLead(lead);
		return "create_lead";
	}
	
	//http://localhost:8080/list
	@RequestMapping("/list")
	public String listAll(Model model) {
		List<Lead> list = leadSer.listAll();
		model.addAttribute("listAll", list);
		return "list_lead";
	}
	
	//http://localhost:8080/updateLead
	@RequestMapping("/updateLead")
	public String updateLead(@RequestParam("id") long id,Model model) {
		Lead updateLead = leadSer.updateLead(id);
		model.addAttribute("id", updateLead);
		return "update_lead";
	}
	
	//http://localhost:8080/update
	@RequestMapping("/update")
	public String update(@ModelAttribute("v") Lead lead,Model model) {
		leadSer.saveLead(lead);
		List<Lead> list = leadSer.listAll();
		model.addAttribute("listAll", list);
		return "list_lead";
	}
	
	//http://localhost:8080/delete
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id,Model model) {
		leadSer.deleteById(id);
		List<Lead> list = leadSer.listAll();
		model.addAttribute("listAll", list);
		return "list_lead";
	}
}