package com.mindtree.personPassport.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.personPassport.entity.Passport;
import com.mindtree.personPassport.entity.Person;
import com.mindtree.personPassport.exception.InvalidPasspportException;
import com.mindtree.personPassport.exception.InvalidPersonException;
import com.mindtree.personPassport.repository.PassportRepo;
import com.mindtree.personPassport.repository.PersonRepo;
import com.mindtree.personPassport.service.PassportService;

@Service
public class PassportServiceImpl implements PassportService{
	
	@Autowired
	private PassportRepo passportRepo;
	
	@Autowired
	private PersonRepo personRepo;

	public List<Passport> getAllDetails() {
		List<Passport> li= new ArrayList<>();
		passportRepo.findAll()
		.forEach(li::add);
		return li;
	}
	
	public Passport getPassportById(int id) throws InvalidPasspportException {
		Passport result = passportRepo.findById(id).orElse(null);
		if(result == null)
			throw new InvalidPasspportException("Passport ID not found");
		else
			return result;
	}
	
	public Passport addPassport(Passport s,int personId) throws InvalidPersonException{
		Person per= personRepo.findById(personId).orElse(null);
		Passport pass= null;
		if(per== null) {
			System.out.println("NULL");
			throw new InvalidPersonException("person with id:"+personId+"not found");
		}
		else {
			s.setPerson(per);
			pass = passportRepo.save(s);
			per.setPassport(pass);
			per = personRepo.save(per);
		}
		System.out.println("Added Details");
		return pass;
	}
}
