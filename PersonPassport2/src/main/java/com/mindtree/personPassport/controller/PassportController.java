package com.mindtree.personPassport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.personPassport.entity.Passport;
import com.mindtree.personPassport.exception.InvalidPasspportException;
import com.mindtree.personPassport.exception.InvalidPersonException;
import com.mindtree.personPassport.exception.PersonPassportException;
import com.mindtree.personPassport.service.serviceImpl.PassportServiceImpl;

@RestController
@RequestMapping("/Passport")
public class PassportController {

	@Autowired
	private PassportServiceImpl passportService;
	
	@RequestMapping("/getAllDetails")
	public List<Passport> getAllDetails() {
		System.out.println("Getting all passport details");
		return passportService.getAllDetails();
	}
	
	@GetMapping("/getDetails/{id}")
	public ResponseEntity<?> getPassportDetails(@PathVariable int id) {
		Passport pass=null;
		System.out.println("Getting passport by id");
		try {
			pass = passportService.getPassportById(id);
			return new ResponseEntity( pass,HttpStatus.ACCEPTED);
		} catch (InvalidPasspportException e) {
//			e.printStackTrace();
			return new ResponseEntity(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

//	@GetMapping("/getDetails/{id}")
//	public Passport getPassportDetails(@PathVariable int id) {
//		Passport pass=null;
//		System.out.println("Getting passport by id");
//		try {
//			pass = passportService.getPassportById(id);
//		} catch (InvalidPasspportException e) {
//			e.printStackTrace();
//		}
//		return pass;
//	}

	@PostMapping("/addDetails/{id}")
	public Passport addDetails(@RequestBody Passport s,@PathVariable int id) {
		Passport pass=null;
		try {
			pass= passportService.addPassport(s,id);
		} catch (InvalidPersonException e) {
			e.printStackTrace();
		}
		return pass;
	}

}
