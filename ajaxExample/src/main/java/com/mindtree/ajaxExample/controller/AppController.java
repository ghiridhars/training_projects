package com.mindtree.ajaxExample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mindtree.ajaxExample.repository.EmployeeRepo;
import com.mindtree.ajaxExample.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/Employee")
public class AppController {

	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private EmployeeServiceImpl empService;
	
	@ModelAttribute("designation")
	public List<String> designation(){
		List<String> designation= new ArrayList<>();
		designation.add("Engineer");
		designation.add("Lead");
		designation.add("Medical");
		return designation;
	}

	@RequestMapping(value = "/")
	public String index(Model m) {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "getEmployeeByDesignation/{designation}", method = RequestMethod.GET)
	public String loadByDesignation(@PathVariable("designation") String designation) {
		Gson gson = new Gson();
		System.out.println(empRepo.getEmployeeByDesignation(designation));
		return gson.toJson(empRepo.getEmployeeByDesignation(designation));
	}
	
}