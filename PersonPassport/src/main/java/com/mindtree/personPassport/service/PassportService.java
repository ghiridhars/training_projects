package com.mindtree.personPassport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.personPassport.entity.Passport;
import com.mindtree.personPassport.exception.InvalidPasspportException;
import com.mindtree.personPassport.exception.InvalidPersonException;

@Service
public interface PassportService{
	
	public List<Passport> getAllDetails();
	
	public Passport getPassportById(int id) throws InvalidPasspportException;
	
	public Passport addPassport(Passport s,int personId) throws InvalidPersonException;
}

