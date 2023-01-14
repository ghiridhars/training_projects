package com.mindtree.loginApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ui.ModelMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.loginApp.dto.UserDto;
import com.mindtree.loginApp.entity.User;
import com.mindtree.loginApp.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	private static ModelMapper mapper = new ModelMapper();
	
	public UserDto entityToDto(User e) {
		ModelMapper mapper = new ModelMapper();
		UserDto map= mapper.map(e,UserDto.class);
		return map;
	}
	
	public User dtoToEntity(UserDto edto) {
		User emp = new User();
		ModelMapper mapper = new ModelMapper();
		User map= mapper.map(edto,User.class);		
		return map;
	}
	
	public List<User> dtoToEntity(List<UserDto> dto)
	{
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<UserDto> entityToDto(List<User> emp)
	{
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

		
	public List<UserDto> getAllUsers() {
		List<User> li = new ArrayList<>();
		userRepo.findAll().forEach(li::add);
		return entityToDto(li);
	}
	public UserDto saveUser(UserDto udto) {
		userRepo.save(dtoToEntity(udto));
		return udto;
	}
	
	public User getByNamePassword(String name,String pwd) {
		return userRepo.findByNamePassword(name, pwd);
	}
	
}
